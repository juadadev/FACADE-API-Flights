// Subsistemas base
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

// Nuevos subsistemas escalables
class Subtitles {
  public void load(String subtitleFile) {
    System.out.println("Cargando subtítulos: " + subtitleFile);
  }
}

class QualitySettings {
  public void setQuality(String level) {
    System.out.println("Configurando calidad: " + level);
  }
}

class ParentalControl {
  public void checkPermissions(String file) {
    System.out.println("Verificando permisos parentales para: " + file);
  }
}

class StreamingService {
  public void connect(String url) {
    System.out.println("Conectando a streaming desde: " + url);
  }
}

// Facade que simplifica todo
class MediaFacade {
  private FileLoader loader = new FileLoader();
  private Compressor compressor = new Compressor();
  private VideoDecoder videoDecoder = new VideoDecoder();
  private AudioDecoder audioDecoder = new AudioDecoder();
  private AudioPlayer audioPlayer = new AudioPlayer();
  private VideoPlayer videoPlayer = new VideoPlayer();
  private Synchronizer synchronizer = new Synchronizer();

  private Subtitles subtitles = new Subtitles();
  private QualitySettings qualitySettings = new QualitySettings();
  private ParentalControl parentalControl = new ParentalControl();
  private StreamingService streaming = new StreamingService();

  public void playMovieFromFile(String file, String subtitleFile, String quality) {
    System.out.println("▶️ Reproduciendo desde archivo local");
    parentalControl.checkPermissions(file);
    loader.loadFile(file);
    compressor.decompress(file);
    videoDecoder.decodeVideo(file);
    audioDecoder.decodeAudio(file);
    subtitles.load(subtitleFile);
    qualitySettings.setQuality(quality);
    audioPlayer.playAudio();
    videoPlayer.playVideo();
    synchronizer.sync();
  }

  public void playMovieFromStreaming(String url, String subtitleFile, String quality) {
    System.out.println("▶️ Reproduciendo desde streaming");
    streaming.connect(url);
    parentalControl.checkPermissions(url);
    videoDecoder.decodeVideo(url);
    audioDecoder.decodeAudio(url);
    subtitles.load(subtitleFile);
    qualitySettings.setQuality(quality);
    audioPlayer.playAudio();
    videoPlayer.playVideo();
    synchronizer.sync();
  }
}

// Cliente (main)
public class MediaPlayer {
  public static void main(String[] args) {
    MediaFacade player = new MediaFacade();

    System.out.println("\n=== Reproducción 1 ===");
    player.playMovieFromFile("pelicula.mp4", "subtitulos.srt", "HD");

    System.out.println("\n=== Reproducción 2 ===");
    player.playMovieFromStreaming("https://streaming.com/pelicula", "subtitulos.srt", "FullHD");
  }
}
