import javax.sound.sampled.*;
import java.io.File;


public class sound implements Runnable
{
    static void playMusic()
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("/Users/lishihao/system/project/snake/snake/src/will.wav"));
            AudioFormat aif =ais.getFormat();
            final SourceDataLine sdl;
            DataLine.Info info =new DataLine.Info(SourceDataLine.class,aif);
            sdl =(SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();

            FloatControl fc=(FloatControl)  sdl.getControl(FloatControl.Type.MASTER_GAIN);
            double value =2;
            float dB = (float) (Math.log(value==0.0 ? 0.0001 : value)/Math.log(10.0)*20.0);
            fc.setValue(dB);
            int nByte = 0;
            final int SIZE =1024*64;
            byte [] Buffer = new byte[SIZE];
            while (nByte !=-1){
                nByte =ais.read(Buffer,0,SIZE);
                sdl.write(Buffer,0,SIZE);
            }sdl.stop();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        System.out.println("Have a good time!");
        while (true){
            playMusic();
        }
    }
}
