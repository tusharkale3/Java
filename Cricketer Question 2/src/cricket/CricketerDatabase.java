package cricket;


	import java.util.ArrayList;
	import java.util.List;

	public class CricketerDatabase {
	    private List<Cricketer> cricketers = new ArrayList<>();

	    public void addCricketer(Cricketer cricketer) {
	        cricketers.add(cricketer);
	    }

	    public Cricketer findCricketerByName(String name) {
	        return cricketers.stream()
	                .filter(cricketer -> cricketer.getName().equalsIgnoreCase(name))
	                .findFirst()
	                .orElse(null);
	    }

	    public List<Cricketer> getAllCricketers() {
	        return new ArrayList<>(cricketers);
	    }

	    public List<Cricketer> getSortedCricketersByRating() {
	        return cricketers.stream()
	                .sorted((c1, c2) -> Integer.compare(c2.getRating(), c1.getRating()))
	                .toList();
	    }
	}


