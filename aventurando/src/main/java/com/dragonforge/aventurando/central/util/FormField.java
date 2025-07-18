package com.dragonforge.aventurando.central.util;

import java.util.Map;

public class FormField {
	private String nome;
    private String label;
    private String tipo;
    private Map<Object, String> options;
    private boolean required;

    public FormField(String nome, String label, String tipo, boolean required) {
        this.nome = nome;
        this.label = label;
        this.tipo = tipo;
        this.required = required;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Map<Object, String> getOptions() { return options; }
    public void setOptions(Map<Object, String> options) { this.options = options; }
    public boolean isRequired() { return required; }
    public void setRequired(boolean required) { this.required = required; }
}