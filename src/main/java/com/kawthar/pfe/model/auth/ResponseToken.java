package com.kawthar.pfe.model.auth;

import com.kawthar.pfe.model.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseToken {
private String token;
private Utilisateur utilisateur;
}
