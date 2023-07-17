import java.util.*;

public class SolucionadorRally {
    private int dias;

    private Random aleatorio;

    public SolucionadorRally() {
        aleatorio = new Random();
    }

    // Gera n pontos de parada aleatórios com distância máxima de d entre pontos
    // adjacentes
    public int[] gerarPontosParadaAleatorios(int n, int d, int distanciaTotal) {
        int[] pontosParada = new int[n];
        pontosParada[0] = aleatorio.nextInt(d); // gera um numero inicial aleatório entre 0 e d
        for (int i = 1; i < n; i++) { // gera os outros números
            // se o ultimo número gerado + d for maior que a distancia total do rally
            // gerar outro número
            if (pontosParada[i - 1] + d > distanciaTotal)
                // gera outro número
                pontosParada[i] = aleatorio.nextInt(distanciaTotal - pontosParada[i - 1]) + pontosParada[i - 1];
            else
                // se o número não estiver na lista, adiciona à lista
                pontosParada[i] = pontosParada[i - 1] + aleatorio.nextInt(d) + 1;

        }
        return pontosParada;
    }

    // Verifica se é possível completar o rally com o conjunto de pontos de parada
    // fornecidos
    public List<Integer> resolverRally(int[] pontosParada, int distanciaMaxima) {
        List<Integer> resultado = new ArrayList<>();
        int atual = 0;
        for (int i = 0; i < pontosParada.length; i++) {
            if (pontosParada[i] - atual > distanciaMaxima) {
                if (i != 0) {
                    resultado.add(pontosParada[i - 1]);
                    atual = pontosParada[i - 1];
                    dias++;
                }
            }
        }
        resultado.add(pontosParada[pontosParada.length - 1]);
        if (pontosParada[pontosParada.length - 1] - atual <= distanciaMaxima)
            dias++;
        return resultado;
    }

    public static void main(String[] args) {
        SolucionadorRally solucionador = new SolucionadorRally();
        int numeroDePontos = 100;
        int distanciaMaxima = 10;
        int distanciaTotal = 1000;
        int[] pontosParada = solucionador.gerarPontosParadaAleatorios(numeroDePontos, distanciaMaxima, distanciaTotal);
        Arrays.sort(pontosParada);
        System.out.println("Número de pontos: " + numeroDePontos);
        System.out.println("Distância total: " + distanciaTotal);
        System.out.println("Distância máxima: " + distanciaMaxima);
        System.out.println("Pontos de parada: " + Arrays.toString(pontosParada));
        long inicio = System.currentTimeMillis();
        List<Integer> resultado = solucionador.resolverRally(pontosParada, distanciaMaxima);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + ((fim - inicio) / 1000) + "s");
        System.out.println("Solução ótima: " + resultado);
        System.out.println("Número de dias: " + solucionador.dias);
    }
}