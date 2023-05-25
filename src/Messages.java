public  class Messages {
    /**
     *
     * @return message before every fight
     */
    public String luckykM() {
        return "Lucky you, you always strike first";
    }

    /**
     * prints all the thing in choice in Game
     * @return all actions
     */
    public String choiceQ(){
        return """
                Choose your option:\s
                 1) Fight \s
                2) Skip\s
                3) Heal\s
                4) Shop""";
    }

    /**
     * Method for the Shop
     * @return message if you enter shop
     */
    public String shopMenu(){
        return """
                Hey you,\s
                 welcome in my shop,\s
                 my name is JArEd and I work here for about hundred years now haha, you don't need to be scared of me I know I have a little beard going on, but no worries, I'll shave it haha.\s
                 You can buy heals and skippers here!\s
                 Are you interested?
                 Go around and have a look, I'm waiting.""";
    }

    /**
     *
     * @return choices in shop
     */
    public String optionsText(){
        return """
                Choose your option:\s
                 1)Gamble  \s
                2) Buy heals\s
                3) Buy skippers\s
                4) Exit shop
                """;
    }

    /**
     * Method if gamble
     * @return funny message if you pick gamble
     */
    public String gambleText(){
        return " Oh, I see that you picked gamble, hahahah. Let's see if you can answer there questions";
    }




}
