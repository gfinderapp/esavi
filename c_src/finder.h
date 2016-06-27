#include "def.h"

typedef struct location{
  //add variables for location here
  //ip? lat/long?
}__((attribute))__ packed Location;

typedef struct player{
  dword pl_id;
  char *pl_user;
  char *pl_pass;
  bool is_guest;
  bool is_online;
  bool is_ingame;
  struct search_info{
    game gm_id;
    byte src_mode; //also serves as union type
    word src_rad;
    byte src_players;
    union blacklist{
      struct player **playls;
      struct player **hostls;
      //host blacklist represents room blacklist to avoid recursive references
    } blackls;
  }__((attribute))__ packed src_info;
  Location *pl_loc;
}__((attribute))__ packed Player;

typedef struct{
  dword rm_id;
  char *rm_name;
  bool is_private;
  char *rm_pass;
  dword host_id;
  byte max_cap;
  byte curr_cap;
  bool is_empty;
  game gm_id;
  Location *rm_loc; //different from host location?
}__((attribute))__ packed Room;

typedef struct{
  game gm_id;
  char *gm_name;
  byte pl_max;
  word src_rad_def;
}__((attribute))__packed Game;
  
  
