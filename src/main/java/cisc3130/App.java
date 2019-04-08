package cisc3130;

import com.kennycason.kumo.nlp.FrequencyFileLoader;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.*;
import java.io.*;
import java.util.*;

public class App {
    public static void main( String[] args ) throws FileNotFoundException, java.io.IOException  {
        final FrequencyFileLoader frequencyFileLoader = new FrequencyFileLoader();

        final java.util.List<WordFrequency> wordFrequencies = frequencyFileLoader.load(new File("Output.txt"));

        final Dimension dimension = new Dimension(600, 296);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("TRex.png"));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        wordCloud.setBackgroundColor(new Color(0xFFFFFF));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x446137), new Color(0x879A7F), new Color(0x948147), new Color(0xC8BEA1), new Color(0xF1C232), new Color( 0x5A764C)));


        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("wordcloud.png");
    }
}