package juego;

public class tablero {

    int dimension;
    int cantidadMinas;
    String tabla[][];

    public tablero(int dim, int numMinas) {
        this.dimension = dim;
        this.cantidadMinas = numMinas;
        this.tabla = new String[dim][dim];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tabla[i][j] = "0";
            }
        }
    }

    public void ubicarMinas() {
        int numMinasUbicadas = 0;

        while (numMinasUbicadas < cantidadMinas) {
            int fila = (int) (Math.random() * dimension);
            int columna = (int) (Math.random() * dimension);

            if (tabla[fila][columna].equals("0")) {
                tabla[fila][columna] = "X";
                numMinasUbicadas++;
            }
        }
    }

    public void calcularMinasAlrededor() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (tabla[i][j].equals("0")) {
                    int contadorMinas = 0;
                    if (i > 0 & j > 0 & i < dimension - 1 & j < dimension - 1) {
                        if (tabla[i - 1][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i - 1][j].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i - 1][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                    }
                    if (i == 0) {
                        if (j > 0 & j < dimension - 1) {
                            if (tabla[i][j - 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i][j + 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i + 1][j - 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i + 1][j].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i + 1][j + 1].equals("X")) {
                                contadorMinas++;
                            }
                        } else {
                            if (j == 0) {
                                if (tabla[i][j + 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i + 1][j + 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i + 1][j].equals("X")) {
                                    contadorMinas++;
                                }
                            } else {
                                if (tabla[i][j - 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i + 1][j - 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i + 1][j].equals("X")) {
                                    contadorMinas++;
                                }
                            }
                        }
                    }
                    if (i == dimension - 1) {
                        if (j > 0 & j < dimension - 1) {
                            if (tabla[i][j - 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i][j + 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i - 1][j - 1].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i - 1][j].equals("X")) {
                                contadorMinas++;
                            }
                            if (tabla[i - 1][j + 1].equals("X")) {
                                contadorMinas++;
                            }
                        } else {
                            if (j == 0) {
                                if (tabla[i - 1][j].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i - 1][j + 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i][j + 1].equals("X")) {
                                    contadorMinas++;
                                }
                            } else {
                                if (tabla[i - 1][j].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i - 1][j - 1].equals("X")) {
                                    contadorMinas++;
                                }
                                if (tabla[i][j - 1].equals("X")) {
                                    contadorMinas++;
                                }
                            }
                        }
                    }
                    if (i > 0 & i < dimension - 1 & j == 0) {
                        if (tabla[i - 1][j].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i - 1][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j + 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j].equals("X")) {
                            contadorMinas++;
                        }
                    }
                    if (i > 0 & i < dimension - 1 & j == dimension - 1) {
                        if (tabla[i - 1][j].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i - 1][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j - 1].equals("X")) {
                            contadorMinas++;
                        }
                        if (tabla[i + 1][j].equals("X")) {
                            contadorMinas++;
                        }
                    }
                    tabla[i][j] = String.valueOf(contadorMinas++);
                }
            }
        }
    }

    public boolean existeMina(int fila, int columna) {
        boolean resultado = false;
        if (tabla[fila][columna].equals("X")) {
            resultado = true;
        }
        return resultado;
    }

    public String entregarValor(int fila, int columna) {
        return tabla[fila][columna];
    }

    public void imprimirTabla() {
        System.out.println("Tabla generada");
        System.out.println("Cuadricula de " + dimension + "x" + dimension);
        System.out.println("Cantidad de minas en la cuadricula: " + cantidadMinas);
        System.out.println("");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (j < dimension - 1) {
                    System.out.print(tabla[i][j] + "-");
                } else {
                    System.out.print(tabla[i][j]);
                }
            }
            System.out.println("");
        }
    }

}
