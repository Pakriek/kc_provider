package com.pat.keycloak.extensions.resource;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class CustomResourceProviderFactory implements RealmResourceProviderFactory {

  // This will result in a new sub path under an existing realm
  // eg. https://localhost:8443/realms/realm-name/custom
  public static final String ID = "custom";

  @Override
  public String getId() {
    return ID;
  }

  @Override
  public int order() {
    return 0;
  }

  @Override
  public RealmResourceProvider create(KeycloakSession keycloakSession) {
    return new CustomResourceProvider(keycloakSession);
  }

  @Override
  public void init(Config.Scope scope) {
  }

  @Override
  public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
  }

  @Override
  public void close() {
  }

}