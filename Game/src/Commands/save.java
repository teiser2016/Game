try {
            String saveFileName = gameContext.getPlayer().getName();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("saves/"+saveFileName+".dat"));
            GameContext LoadedGameContext = (GameContext)inputStream.readObject();

            gameContext.setPlayer(LoadedGameContext.getPlayer());
            gameContext.setCurrentRoom(LoadedGameContext.getCurrentRoom());
            gameContext.setHistory(LoadedGameContext.getHistory());

            inputStream.close();
            outputMessages.add(new OutputMessage(1210, PrintStyle.ONLY_TITLE));
            outputMessages.add(new OutputMessage(0, PrintStyle.BREAK));
        }
        catch(Exception ex) {
            outputMessages.add(new OutputMessage(1211, PrintStyle.ONLY_TITLE));
            outputMessages.add(new OutputMessage(0, PrintStyle.BREAK));
        }
        return outputMessages;