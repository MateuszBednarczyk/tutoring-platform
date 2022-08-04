package pl.simpleascoding.tutoringplatform.dto.requests;

import org.hibernate.annotations.Immutable;

@Immutable
public record CredentialsDTO(String username, String password) {
}
