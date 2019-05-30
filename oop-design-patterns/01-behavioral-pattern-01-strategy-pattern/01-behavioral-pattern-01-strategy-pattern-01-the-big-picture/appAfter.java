public class appAfter{
    public static void main(String[] args) {
        MediaFile media = new MediaFile();
        media.play();

        media.setPlayBehavior(new PlayAudio());
        media.play();

        media.setPlayBehavior(new PlayVideo());
        media.play();
    }
}

class MediaFile {
    private PlayBehavior playBehavior;

    public void play(){
        if (playBehavior != null)
            playBehavior.play();
        else
            System.out.println("play behavior not support");
    }

    public PlayBehavior getPlayBehavior() {
        return playBehavior;
    }

    public void setPlayBehavior(PlayBehavior playBehavior) {
        this.playBehavior = playBehavior;
    }


}

interface PlayBehavior {
    public void play();
}

class PlayVideo implements PlayBehavior {

    public void play(){
        System.out.println("play video");
    }
}

class PlayAudio implements PlayBehavior {
    
    public void play(){
        System.out.println("play audio");
    }
}