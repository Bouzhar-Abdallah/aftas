package bouzhar.aftas.demo.auth;


import bouzhar.aftas.demo.enums.IdentityDocumentType;
import bouzhar.aftas.demo.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String name;
  private String familyName;
  private String email;
  private String password;
  private LocalDate accessionDate;
  private String nationality;
  private IdentityDocumentType identityDocument;
  private String identityNumber;
  private Role role;
}
