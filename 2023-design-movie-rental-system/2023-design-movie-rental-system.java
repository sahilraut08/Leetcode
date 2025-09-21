class MovieRentingSystem {
    class Item {
        int shopId;
        int movieId;
        int price;

        public Item(int shopId, int movieId, int price) {
            this.shopId = shopId;
            this.movieId = movieId;
            this.price = price;
        }

        @Override
        public String toString() {
            return "[" + shopId + ", " + movieId + ", "+ price + "]";
        }
    }

    private TreeSet<Item> rentedMovies;
    private HashMap<Integer, TreeSet<Item>> unrentedMovies;

    private HashMap<Integer, HashMap<Integer, Item>> shopMap;

    public MovieRentingSystem(int n, int[][] entries) {
        rentedMovies = new TreeSet<>((a,b) -> (a.price == b.price) ? 
            (a.shopId == b.shopId) ? a.movieId - b.movieId : a.shopId - b.shopId : a.price - b.price);
        unrentedMovies = new HashMap<>();
        shopMap = new HashMap<>();

        for (int[] e : entries) {
            unrentedMovies.putIfAbsent(e[1], new TreeSet<>((a,b) -> (a.price == b.price) ? 
            (a.shopId == b.shopId) ? a.movieId - b.movieId : a.shopId - b.shopId : a.price - b.price));

            Item item = new Item(e[0], e[1], e[2]);
            shopMap.putIfAbsent(e[0], new HashMap<>());
            shopMap.get(e[0]).put(e[1], item);
            unrentedMovies.get(e[1]).add(item);
        }
    }
    
    public List<Integer> search(int movie) {
        TreeSet<Item> movies = unrentedMovies.getOrDefault(movie, new TreeSet<>());

        List<Integer> result = new ArrayList<>();

        int n = 0;
        for (Item i : movies) {
            if (n == 5) break;
            result.add(i.shopId);
            n++;
        }
        return result;
    }
    
    public void rent(int shop, int movie) {
        Item item = shopMap.get(shop).get(movie);
        unrentedMovies.get(movie).remove(item);
        rentedMovies.add(item);
    }
    
    public void drop(int shop, int movie) {
        Item item = shopMap.get(shop).get(movie);

        rentedMovies.remove(item);
        unrentedMovies.get(movie).add(item);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();

        int n = 0;
        for (Item i : rentedMovies) {
            if (n == 5) break;
            List<Integer> entry = new ArrayList<>();
            entry.add(i.shopId);
            entry.add(i.movieId);

            result.add(entry);
            n++;
        }

        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */