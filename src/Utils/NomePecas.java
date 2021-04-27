package Utils;

import Pecas.Abstract.Peca;
import Utils.Cores;
import Pecas.Peao;
import Pecas.Bispo;
import Pecas.Cavalo;
import Pecas.Rainha;
import Pecas.Rei;

public enum NomePecas {
    PEAO,
    BISPO,
    CAVALO,
    TORRE,
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
            case TORRE:
                return cor == Cores.BRANCO ? "T" : "t";
            case RAINHA:
                return cor == Cores.BRANCO ? "Q" : "q";
            case REI:
                return cor == Cores.BRANCO ? "K" : "k";
            default:
                return "x";
        }
    }
}
