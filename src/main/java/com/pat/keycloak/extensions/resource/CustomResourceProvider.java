package com.pat.keycloak.extensions.resource;

import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import com.pat.keycloak.extensions.mappers.GroupMapper;
import com.pat.keycloak.extensions.models.GroupDto;

import java.util.List;
import java.util.stream.Collectors;

public class CustomResourceProvider implements RealmResourceProvider {

    private static final Logger log = Logger.getLogger(CustomResourceProvider.class);

    private final KeycloakSession session;
    private final GroupMapper groupMapper;

    public CustomResourceProvider(KeycloakSession session) {
        this.session = session;
        this.groupMapper = new GroupMapper();
    }

    @GET
    @Path("mygroups")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getUsersByName() {
        log.infof("Get groups");

        final List<GroupDto> myGroups = session.groups().getGroupsStream(session.getContext().getRealm())
                .map(e -> groupMapper.mapToGroupDto(e)).collect(Collectors.toList());

        log.infof("myGroups", myGroups);

        return Response.status(Response.Status.OK).entity(myGroups).build();
    }

    @Override
    public Object getResource() {
        return this;
    }

    @Override
    public void close() {

    }

}