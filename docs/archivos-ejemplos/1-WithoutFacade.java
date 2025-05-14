// Subsistemas individuales
class FileLoader {
  public void loadFile(String fileName) {
    System.out.println("Cargando archivo: " + fileName);
  }
}

class Compressor {
  public void decompress(String fileName) {
    System.out.println("Descomprimiendo archivo: " + fileName);
  }
}

class VideoDecoder {
  public void decodeVideo(String fileName) {
    System.out.println("Decodificando video de: " + fileName);
  }
}

class AudioDecoder {
  public void decodeAudio(String fileName) {
    System.out.println("Decodificando audio de: " + fileName);
  }
}

class AudioPlayer {
  public void playAudio() {
    System.out.println("Reproduciendo audio...");
  }
}

class VideoPlayer {
  public void playVideo() {
    System.out.println("Reproduciendo video...");
  }
}

class Synchronizer {
  public void sync() {
    System.out.println("Sincronizando audio y video...");
  }
}

// Cliente sin Facade
public class MediaPlayerWithoutFacade {
  public static void main(String[] args) {
    String file = "pelicula.mp4";

    FileLoader loader = new FileLoader();
    Compressor compressor = new Compressor();
    VideoDecoder videoDecoder = new VideoDecoder();
    AudioDecoder audioDecoder = new AudioDecoder();
    AudioPlayer audioPlayer = new AudioPlayer();
    VideoPlayer videoPlayer = new VideoPlayer();
    Synchronizer synchronizer = new Synchronizer();

    loader.loadFile(file);
    compressor.decompress(file);
    videoDecoder.decodeVideo(file);
    audioDecoder.decodeAudio(file);
    audioPlayer.playAudio();
    videoPlayer.playVideo();
    synchronizer.sync();
  }
}
