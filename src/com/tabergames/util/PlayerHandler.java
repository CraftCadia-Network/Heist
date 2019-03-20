
	public static int Rank_SECURITY = 100;
	public static int Rank_ROBBER = 90;
	public static int Rank_DEFAULT = 0;
	
	public static void SetupPlayer(Player p) {
		
		File f = new File("plugins/Heist/PlayerData/" + p.getUniqueId() + ".yml");
		if(!f.exists()) {
			
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
		yml.addDefault("Name", p.getName());
		yml.addDefault("Rank", Rank_DEFAULT);
		yml.options().copyDefaults(true);
		try {
			yml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean setRank(Player p, String rank) {
		
		File f = new File("plugins/Heist/PlayerData/" + p.getUniqueId() + ".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
		yml.set("Rank", rank);
		try {
			yml.save(f);
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static int getRank(Player p) {
		
		File f = new File("plugins/Heist/PlayerData/" + p.getUniqueId() + ".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
		return yml.getString("Rank");
	}
	
