package io.github.wendellvalentim.mscartoes.infra.mqueue.records;

public record DadosCartao(String payload) {

    @Override
    public String toString() {
        return "[LOG-MENSAGEM] -> " + payload;
    }
}
