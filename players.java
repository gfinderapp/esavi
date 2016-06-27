public class Player{

	private int player_id;
	private String username;
	private String password;
	boolean isOnline;
	boolean inGame;
	private char curr_game_id;
	private int curr_room_id;
	private Location location;
	private int search_rad;

	public Player(int total_players){
		this.username="guest";
		this.password="esavi";
		this.player_id=total_players; //dont forget to increment total counter
		this.isOnline=true;
		this.inGame=false;
		this.curr_game_id=0;
		this.curr_room_id=0;

	}

	public Player(int total_players,const String user,const String pass){
		this.username=user;
		this.password=pass;
		this.player_id=total_players; //dont forget to increment total counter
		this.isOnline=true;
		this.inGame=false;
		this.curr_game_id=0;
		this.curr_room_id=0;
		//add this location
	}

	//yknow, just in case
	private boolean confirmPass(String pass){
		return Objects.equals(this.password,pass);
	}

	public boolean loginUser(String user,String pass){
		if !(Objects.equals(this.username,user) && confirmPass(pass))
		return false;
		if (this.isOnline)
			return false;
		this.isOnline=true;
		return true;
	}

	public int getID(){
		return this.player_id;
	}

	public int getSRad(){
		return this.search_rad;
	}

	public void addInGame(char game_id,int room_id){
		this.curr_game_id=game_id;
		this.curr_room_id=room_id;
		this.inGame=true;
	}

	public void removeFromGame(){
		this.curr_game_id=0;
		this.curr_room_id=0;
		this.inGame=false;
	}

	public String roomInfo(){
		return "Player " + this.username + " is in room " + this.curr_room_id;
	}

	public Location getLocation(){
		return this.location;
	}
}
