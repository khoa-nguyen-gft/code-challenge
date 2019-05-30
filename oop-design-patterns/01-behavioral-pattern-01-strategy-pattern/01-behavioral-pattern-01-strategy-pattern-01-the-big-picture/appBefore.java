public class appBefore{
    public static void main(String[] args) {
        MediaFile video = new PlayVideo();
        video.play();

        MediaFile audio = new PlayAudio();
        audio.play();

        MediaFile image = new ImageAudio();
        image.play();
        
        MediaFile playable = new PlayableAudio();
        playable.play();
    }
}

interface MediaFile {
    public void play();
}

class PlayVideo implements MediaFile {

    public void play(){
        System.out.println("play video");
    }
}

class PlayAudio implements MediaFile {
    
    public void play(){
        System.out.println("play audio");
    }
}


class ImageAudio implements MediaFile {
    
    public void play(){
        System.out.println("image audio");
    }
}


class PlayableAudio implements MediaFile {
    
    public void play(){
        System.out.println("playable audio");
    }
}