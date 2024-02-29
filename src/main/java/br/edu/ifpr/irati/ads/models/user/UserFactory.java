package br.edu.ifpr.irati.ads.models.user;

public class UserFactory {
    public static User getInstance(String typeUser) {
        return switch (typeUser.toUpperCase()) {
            case "DEFAULT" -> new Default();
            case "ADMIN" -> new Admin();
            case "HELPER" -> new Helper();
            default -> null;
        };
    }
}