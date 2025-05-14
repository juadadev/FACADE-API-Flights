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
  public void decode(String fileName) {
    System.out.println("Decodificando video de: " + fileName);
  }
}

class AudioDecoder {
  public void decode(String fileName) {
    System.out.println("Decodificando audio de: " + fileName);
  }
}

class AudioPlayer {
  public void play() {
    System.out.println("Reproduciendo audio...");
  }
}

class VideoPlayer {
  public void play() {
    System.out.println("Reproduciendo video...");
  }
}

class Synchronizer {
  public void sync() {
    System.out.println("Sincronizando audio y video...");
  }
}

class Subtitles {
  public void load(String file) {
    System.out.println("Cargando subtítulos: " + file);
  }
}

class QualitySettings {
  public void set(String quality) {
    System.out.println("Estableciendo calidad: " + quality);
  }
}

class ParentalControl {
  public void check(String file) {
    System.out.println("Verificando control parental para: " + file);
  }
}

class StreamingService {
  public void connect(String url) {
    System.out.println("Conectando a streaming desde: " + url);
  }
}

// ===== Facades Especializados =====

class VideoPlaybackFacade {
  private FileLoader loader = new FileLoader();
  private Compressor compressor = new Compressor();
  private VideoDecoder decoder = new VideoDecoder();
  private VideoPlayer player = new VideoPlayer();

  public void playVideoFromFile(String file) {
    loader.loadFile(file);
    compressor.decompress(file);
    decoder.decode(file);
    player.play();
  }

  public void playVideoFromStream(String url) {
    decoder.decode(url);
    player.play();
  }
}

class AudioPlaybackFacade {
  private AudioDecoder decoder = new AudioDecoder();
  private AudioPlayer player = new AudioPlayer();

  public void playAudio(String source) {
    decoder.decode(source);
    player.play();
  }
}

class SubtitlesFacade {
  private Subtitles subtitles = new Subtitles();

  public void loadSubtitles(String file) {
    subtitles.load(file);
  }
}

class QualityFacade {
  private QualitySettings settings = new QualitySettings();

  public void applyQuality(String level) {
    settings.set(level);
  }
}

class ParentalControlFacade {
  private ParentalControl control = new ParentalControl();

  public void verify(String content) {
    control.check(content);
  }
}

class StreamingFacade {
  private StreamingService streaming = new StreamingService();

  public void connectToStream(String url) {
    streaming.connect(url);
  }
}

// ===== Facade Principal =====

class MediaFacade {
  private VideoPlaybackFacade video = new VideoPlaybackFacade();
  private AudioPlaybackFacade audio = new AudioPlaybackFacade();
  private SubtitlesFacade subtitles = new SubtitlesFacade();
  private QualityFacade quality = new QualityFacade();
  private ParentalControlFacade parental = new ParentalControlFacade();
  private StreamingFacade streaming = new StreamingFacade();
  private Synchronizer synchronizer = new Synchronizer();

  public void playMovieFromFile(String file, String subtitlesFile, String qualityLevel) {
    System.out.println("▶️ Reproduciendo desde archivo local");
    parental.verify(file);
    video.playVideoFromFile(file);
    audio.playAudio(file);
    subtitles.loadSubtitles(subtitlesFile);
    quality.applyQuality(qualityLevel);
    synchronizer.sync();
  }

  public void playMovieFromStreaming(String url, String subtitlesFile, String qualityLevel) {
    System.out.println("▶️ Reproduciendo desde streaming");
    streaming.connectToStream(url);
    parental.verify(url);
    video.playVideoFromStream(url);
    audio.playAudio(url);
    subtitles.loadSubtitles(subtitlesFile);
    quality.applyQuality(qualityLevel);
    synchronizer.sync();
  }
}

// ===== Cliente =====

public class MediaPlayer {
  public static void main(String[] args) {
    MediaFacade player = new MediaFacade();

    System.out.println("\n=== Reproducción Local ===");
    player.playMovieFromFile("pelicula.mp4", "subtitulos.srt", "HD");

    System.out.println("\n=== Reproducción Streaming ===");
    player.playMovieFromStreaming("https://video.com/pelicula", "subtitulos.srt", "FullHD");
  }
}
