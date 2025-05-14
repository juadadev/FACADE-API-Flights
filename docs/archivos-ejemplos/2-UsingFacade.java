// Misma lógica interna
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

// Aquí está el Facade
class MediaFacade {
  private FileLoader loader = new FileLoader();
  private Compressor compressor = new Compressor();
  private VideoDecoder videoDecoder = new VideoDecoder();
  private AudioDecoder audioDecoder = new AudioDecoder();
  private AudioPlayer audioPlayer = new AudioPlayer();
  private VideoPlayer videoPlayer = new VideoPlayer();
  private Synchronizer synchronizer = new Synchronizer();

  public void playMovie(String fileName) {
    loader.loadFile(fileName);
    compressor.decompress(fileName);
    videoDecoder.decodeVideo(fileName);
    audioDecoder.decodeAudio(fileName);
    audioPlayer.playAudio();
    videoPlayer.playVideo();
    synchronizer.sync();
  }
}

// Cliente usando Facade
public class MediaPlayerWithFacade {
  public static void main(String[] args) {
    MediaFacade media = new MediaFacade();
    media.playMovie("pelicula.mp4");
  }
}
