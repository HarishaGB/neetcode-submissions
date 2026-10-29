class Twitter {

    // Represents one tweet
    private static class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time, Tweet next) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = next;
        }
    }

    // User ID -> newest tweet of that user
    private Map<Integer, Tweet> tweets;

    // User ID -> users they follow
    private Map<Integer, Set<Integer>> following;

    // Increasing timestamp for every new tweet
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        // Add the new tweet at the head of the list
        Tweet newTweet = new Tweet(
            tweetId,
            timestamp++,
            tweets.get(userId)
        );

        tweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // Max Heap: newest tweet comes first
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Always include the user's own tweets
        if (tweets.containsKey(userId)) {
            maxHeap.offer(tweets.get(userId));
        }

        // Include the newest tweet from each followed user
        for (int followeeId :
                following.getOrDefault(userId, Collections.emptySet())) {

            if (tweets.containsKey(followeeId)) {
                maxHeap.offer(tweets.get(followeeId));
            }
        }

        // Retrieve at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet current = maxHeap.poll();

            feed.add(current.tweetId);

            // Add the next older tweet from the same user
            if (current.next != null) {
                maxHeap.offer(current.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        following
            .computeIfAbsent(followerId, id -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following
            .getOrDefault(followerId, Collections.emptySet())
            .remove(followeeId);
    }
}
