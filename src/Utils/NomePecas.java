package Utils;

import Utils.Cores;

public enum NomePecas {
    PEAO,
    BISPO,
    CAVALO,
    RAINHA,
    REI;

    public String getLetra(NomePecas peca, Cores cor) {
        switch (peca) {
            case PEAO:
                return cor == Cores.BRANCO ? "P" : "p";
            case BISPO:
                return cor == Cores.BRANCO ? "B" : "b";
            case CAVALO:
                return cor == Cores.BRANCO ? "C" : "c";
            case RAINHA:
                return cor == Cores.BRANCO ? "Q" : "q";
            case REI:
                return cor == Cores.BRANCO ? "K" : "k";
            default:
                return "x";
        }
    }
}
