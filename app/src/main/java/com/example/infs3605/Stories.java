package com.example.infs3605;

import java.util.ArrayList;

    public class Stories {
        public Stories(String id, String title, String story, String url) {
            this.id = id;
            this.title = title;
            this.story = story;
            this.url = url;
        }

        private String id;
        private String title;
        private String story;
        private String url;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStory() {
            return story;
        }

        public void setStory(String story) {
            this.story = story;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static ArrayList<Stories> getStories() {
            ArrayList<Stories> stories = new ArrayList<>();
            stories.add(new Stories("1", "Tiddalik The Frog",
                    "Once upon a time, a long time ago, in the Dreamtime, lived a frog called Tiddalick.\n" +
                    "\n" +
                    "Tiddalick was the largest frog in the entire world. One very warm morning, he woke up with feeling very, very thirsty and started to drink the fresh water. He drank and he drank and he kept drinking until all the fresh water in the entire billabong was gone!\n" +
                    "\n" +
                    "When the other animals arrived at the billabong to get their morning drink, they found it was all dried up. This made them very sad.\n" +
                    "\n" +
                    "They knew Tiddalick the frog had drunk all the water. They knew they needed to come up with a plan to get the water back, but they didn’t know how. They thought and they thought and they thought until they realised that the best way to get the water back was to make Tiddalick laugh. If they could make him laugh then all the water would come spilling out of his mouth and back into the billabong!\n" +
                    "\n" +
                    "The first animal to try and make him laugh was the echidna. She rolled herself up into a tight little ball and rolled down the bank of the billabong like a bowling ball! The kangeroo laughed and so did the emu, but Tiddalick didn’t laugh.\n" +
                    "\n" +
                    "The next animal to try and make Tiddalick laugh was the wombat. The wombat stood up on his hind legs and danced around in a circle until he fell over in the dirt! The Galah laughed and so did the goanna, but Tiddalick didn’t laugh.\n" +
                    "\n" +
                    "The next animal to try and make Tiddalick laugh was the kookaburra. She perched herself on a branch close to Tiddalick and told her funniest story. It was so funny that she burst out laughing! But Tiddalick didn’t laugh. He just sat there with his big belly full of all the water.\n" +
                    "\n" +
                    "Finally, the snake decided to try and make Tiddalick laugh. She started to dance and dance, wriggling and squirming all over the ground until she eventually tied herself into a knot. The knot was so tight that she struggled and struggled to untie herself but was stuck! Tiddalick watched struggle around, trying to untie herself, and let out a small chuckle. That small chuckle turned into a rumbling in his tummy before it turned into a great big belly laugh! The water came gushing out of his mouth and filled the billabong back up once again.\n" +
                    "\n" +
                    "All the animals jumped with joy as they took big, long, gulps of water to quench their thirst.",
                    "https://www.youtube.com/watch?v=0y3Ta5xcKV4&ab_channel=RedPixelsAnimation"));
            return stories;
        }

        public static Stories getStory(String id) {
            ArrayList<Stories> stories = Stories.getStories();
            for (final Stories story : stories) {
                if (story.getId().equals(id)) {
                    return story;
                }
            }
            return null;
        }
    }
