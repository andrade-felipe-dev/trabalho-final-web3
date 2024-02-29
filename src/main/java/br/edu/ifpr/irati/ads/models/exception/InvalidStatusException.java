package br.edu.ifpr.irati.ads.models.exception;

public class InvalidStatusException extends Exception {
    public InvalidStatusException() {
        super("Status inválido para operação.");
    }
}
