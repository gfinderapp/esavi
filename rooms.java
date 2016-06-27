public class Room{
	private int room_id;
	private String room_name;
	private int rm_game_id;
	private int host_id;
	private char max_players;
	private char count_players;
	private boolean isFull;
	private boolean isPrivate;
	private String room_pw;
	private String player_id_list;

	public Room(int total_rooms,String name,int game,int host){
		this.room_id=total_rooms; //increment counter;
		this.room_name=name;
		this.rm_game_id=game;
		this.host_id=host;
		//max players defined by game
		this.count_players=1;
		this.isFull=false;
		this.isPrivate=false;
		this.room_pw="";
		this.player_id_list=""+this.host_id;
	}

	public Room(int total_rooms,String name,int game,int host,String pass){
		this.room_id=total_rooms; //increment counter;
		this.room_name=name;
		this.rm_game_id=game;
		this.host_id=host;
		//max players defined by game
		this.count_players=1;
		this.isFull=false;
		this.isPrivate=true;
		this.room_pw=pass;
		this.player_id_list=""+this.host_id;
	}

	private void addPlayer(Player new){
		int new_id=new.getID();
		(this.count_players)++;
		if (this.count_players==this.max_players)
			this.isFull=true;
		this.player_id_list+=(";"+new_id);
	}

	private void removePlayer(Player rem){
		int rem_id=rem.getID();
		(this.count_players)--;
		this.isFull=false;
		this.player_id_list.replace(";"+rem_id,"");
	}

	//bad af, will do the job though *crosses fingers*
	public void searchClosest(Player[] list){
		int len=list.length;
		int[] currClose=new int[max_players-1];
		int cntCurr=0;
		while (!this.isFull){
			float[] dist=new float[len];
			for (int i=0;i<len && i!=host_id;i++){
				for (int c=0;c<currClose.length;c++){
					if (i==currClose[c])
						continue;
				}
				if (!list[i].isOnline)
					dist[i]=Double.MAX_VALUE;
				else 
					dist[i]=list[host_id].getLocation().distanceTo(list[i].getLocation());
			}
			double minloc=Double.MAX_VALUE;
			int id;
			for (int i=0;i<len && i!=host_id;i++){
				for (int c=0;c<currClose.length;c++){
					if (i==currClose[c])
						continue;
				}
				if (dist[i]<minloc && dist[i]<list[i].getSRad()){
					minloc=dist[i];
					id=i;
				}
			}
			addPlayer(list[id]);
			addInGame(this.rm_game_id,this.room_id); 
			currClose[cntCurr++]=id;
		}
	}
}
