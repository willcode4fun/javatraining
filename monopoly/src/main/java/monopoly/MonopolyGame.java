package monopoly;

public class MonopolyGame {
	private Player[] _players;
	private Board _board;
	private int _roundsToPlay;

	public MonopolyGame(int nbPlayers, int roundsToPlay) {
		System.out.println("Welcome to Monopoly");
		_roundsToPlay = roundsToPlay;

		// 1. Create the board
		_board = new Board();

		// 3. Build the players list
		initPlayers(nbPlayers);
	}

	private void initPlayers(int nbPlayers) {
		_players = new Player[nbPlayers];
		String pieces[] = { "Rouge", "Vert", "Bleu", "Magenta", "Jaune",
				"Noir", "Blanc", "Orange", "Violet", "Gris"};
		for (int i = 0; i < nbPlayers; i++) {
			_players[i] = new Player(pieces[i], _board.getStartSquare());
		}
	}

	public void play() {
		for (int i = 0; i < _roundsToPlay; i++) {
			playRound();
		}
	}

	public void playRound() {
		for (int i = 0; i < _players.length; i++) {
			_players[i].takeTurn();
		}
		System.out.println();
	}

	public void addPlayer() {
		if(_players.length >= 10){
			throw new RuntimeException("Max number of players");
		}
		initPlayers(_players.length+1);
	}

	public int getPlayerCount() {
		return _players.length;
	}

	public void removePlayer() {
		if(_players.length <= 2){
			throw new RuntimeException("Min number of players");
		}
		initPlayers(_players.length-1);
	}

	public void resetPlayers() {
		initPlayers(2);
	}
}
