/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc025.electriciansgame;

/**
 *
 * @author savio
 */

import java.util.*;

import javax.sound.sampled.SourceDataLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Game {
    static User currentUser = null;
    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final Scanner scan = new Scanner(System.in);
    static List<Phase> phases = new ArrayList<>();
    HashMap<String, Piece> dictPiece = new HashMap<String, Piece>();

    public static void simulation(Board newBoard) {
        Piece peca1 = new PieceLink(2);
        Piece peca2 = new PieceLink(2);
        Piece peca3 = new PieceLink(2);
        Piece peca4 = new PieceLink(2);
        Piece peca5 = new PieceLink(1);
        Piece peca6 = new PieceLink(1);
        Piece peca7 = new PieceLink(1);
        Piece peca8 = new PieceLink(1);
        Piece peca9 = new PieceLink(1);
        Piece peca10 = new PieceLink(1);
        Piece cruz = new PieceCross(1);
        Piece joelho = new PieceKnee(3);

        newBoard.insertPiece(peca1, 0, 0);
        newBoard.insertPiece(cruz, 0, 1);

        newBoard.insertPiece(peca9, 1, 1);
        newBoard.insertPiece(peca10, 2, 1);

        newBoard.insertPiece(peca3, 0, 2);
        newBoard.insertPiece(peca4, 0, 3);
        newBoard.insertPiece(joelho, 0, 4);
        newBoard.insertPiece(peca6, 1, 4);
        newBoard.insertPiece(peca7, 2, 4);
        newBoard.insertPiece(peca8, 3, 4);
        newBoard.insertPiece(peca5, 4, 4);

        newBoard.printBoard();
        newBoard.printAllConexions();

    }

    public static void changePiecePosition(Piece piece, Board board) {
        System.out.println("Qual posi????o deseja que a pe??a tenha?");
        int position = Integer.parseInt(scanner.nextLine());

        // Se posi????o nao for a atual
        if (position != piece.getPosition()) {
            piece.setPosition(position);
            piece.resetPiecesConnected();
            piece.fillPiecesConnected(board.getBoard());
            board.printAllConexions();
        }
    }

    // public static void startGame(Board newBoard) {

    // System.out.print("Inicia jogo!");
    // Phase newphase = new Phase();

    // int line = 0, col = 0;
    // while (!newBoard.gameIsFinished(newphase)) {
    // newBoard.printBoard();

    // System.out.println("Linha da pe??a: ");
    // line = Integer.parseInt(scanner.nextLine());

    // System.out.println("Coluna da pe??a: ");
    // col = Integer.parseInt(scanner.nextLine());

    // try {
    // Piece p = newBoard.getPiece(line, col);
    // changePiecePosition(p, newBoard);

    // } catch (ArrayIndexOutOfBoundsException e) {
    // System.out.println("Invalid position of board");
    // }
    // }
    // }

    public static void getInitialPhases() {
        List<Integer> lines = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        List<Piece> pieces = new ArrayList<>();
        String[] folders = { "Easy", "Medium", "Hard" };
        for (String currentlevel : folders) {
            File folder = new File("Phases/" + currentlevel);
            File[] files = folder.listFiles();
            for (File file : files) {
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    try {
                        String creator = br.readLine();
                        String name = br.readLine();
                        String level = br.readLine();
                        int initPosition = Integer.parseInt(br.readLine());
                        int exitPosition = Integer.parseInt(br.readLine());
                        Phase current = new Phase(creator, name, level, initPosition, exitPosition);
                        while (br.ready()) {
                            String readed = br.readLine();
                            if (readed.equals("end"))
                                break;
                            Piece piece = Piece.getClassByString(readed.split("-")[1]);
                            String coord = readed.split("-")[0];
                            pieces.add(piece);
                            lines.add(Integer.parseInt(coord.split(",")[0]) - 1);
                            columns.add(Integer.parseInt(coord.split(",")[1]) - 1);
                        }
                        current.createGame(pieces, lines, columns);
                        phases.add(current);
                        br.close();
                        fr.close();
                    } catch (IOException err) {
                        System.out.println("Erro: erro na leitura do arquivo " + file);
                    }
                } catch (FileNotFoundException err) {
                    System.out.println("Erro: arquivo n??o encontrado!");
                }
            }
        }
    }

    public static void createUser() {
        boolean responseLogin = false;
        int response;
        String role;
        String name;
        String userName;
        String password;
        System.out.println("Selecione o tipo de usuario:");
        System.out.println("[1] - Admin");
        System.out.println("[2] - Jogador");
        System.out.println("[3] - Sair");
        response = scan.nextInt();
        if (response == 1)
            role = "Admin";
        else if (response == 2)
            role = "Player";
        else
            return;
        System.out.println("Nome: ");
        name = scan.next();
        System.out.println("Username: ");
        userName = scan.next();
        System.out.println("Password: ");
        password = scan.next();
        for (User current : users) {
            responseLogin = current.validateLogin(userName, password);
            if (responseLogin) {
                System.out.println("Esse usuario ja existe!");
                break;
            }
        }
        if (!responseLogin) {
            users.add(User.getClassByRole(role, name, userName, password));
        }
    }

    public static void doLogin() {
        Boolean response;
        String userName;
        String password;
        System.out.println("Username: ");
        userName = scan.next();
        System.out.println("Password: ");
        password = scan.next();
        for (User current : users) {
            response = current.validateLogin(userName, password);
            if (response) {
                currentUser = current;
                break;
            }
        }
    }

    public static void playPhase() {
        System.out.println("play phase");
    }

    public static void createPhase() {
        System.out.println("create phase");
    }

    public static void seeRecords() {
        System.out.println("see records");
    }

    public static void mapOptions(int response, String role) {
        switch (role) {
            case "Admin":
                switch (response) {
                    case 1:
                        createPhase();
                        break;
                    case 2:
                        seeRecords();
                        break;
                }
            case "Player":
                switch (response) {
                    case 1:
                        playPhase();
                        break;
                    case 2:
                        seeRecords();
                        break;
                }
            case "Guest":
                playPhase();
        }
    }

    // Main
    public static void main(String args[]) {
        int response;
        boolean closeGame = false;
        getInitialPhases();
        for (Phase current : phases) {
            System.out.print("Fase carregada = ");
            System.out.println(current.getName());
        }
        System.out.println();
        while (!closeGame) {
            while (currentUser == null) {
                response = 0;
                System.out.println("====== Login: ======");
                System.out.println("[1] - Fazer login");
                System.out.println("[2] - Criar usuario");
                System.out.println("[3] - Jogar como convidado2");
                System.out.println("[4] - Sair do jogo");
                response = scan.nextInt();
                switch (response) {
                    case 1:
                        doLogin();
                        break;
                    case 2:
                        createUser();
                        break;
                    case 3:
                        currentUser = new Guest();
                        break;
                    case 4:
                        closeGame = true;
                        break;
                }
                if (closeGame)
                    break;
            }
            System.out.println("====== Menu: ======");
            response = currentUser.getFunctions();
            switch (response) {
                case 9:
                    closeGame = true;
                    break;
                case 8:
                    currentUser = null;
                    break;
            }
            mapOptions(response, currentUser.getRole());
        }

        // Board newBoard = new Board();
        // simulation(newBoard);

        // startGame(newBoard);

    }
}
