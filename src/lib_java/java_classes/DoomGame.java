package vizdoom;

import java.util.ArrayList;
import java.util.List;
import vizdoom.*;

public class DoomGame{
    static {
        System.loadLibrary("vizdoom");
    }

    public long internalPtr = 0;
    public DoomGame(){
        this.DoomGameNative();
    }

    public native int doomTics2Ms(double tics, int ticrate);
    public native int ms2DoomTics(double ms, int ticrate);
    public native int doomTics2Sec(double tics, int ticrate);
    public native int sec2DoomTics(double sec, int ticrate);
    public native double doomFixedToDouble(int doomFixed);
    public native boolean isBinaryButton(Button button);
    public native boolean isDeltaButton(Button button);

    private native void DoomGameNative();
    public native boolean loadConfig(String file);

    public native boolean init();
    public native void close();

    public native void newEpisode();
    public native void newEpisode(String file);
    public native void replayEpisode(String file);
    public native void replayEpisode(String file, int player);

    public native boolean isRunning();

    public native void setAction(int[] actions);
    public native void advanceAction();
    public native void advanceAction(int tics);
    public native void advanceAction(int tics, boolean stateUpdate);
    public native double makeAction(int[] actions);
    public native double makeAction(int[] actions, int tics);

    public native GameState getState();

    public native int[] getLastAction();

    public native boolean isNewEpisode();
    public native boolean isEpisodeFinished();

    public native boolean isPlayerDead();
    public native void respawnPlayer();

    public native void addAvailableButton(Button button);
    public native void addAvailableButton(Button button, int maxValue);
    public native void clearAvailableButtons();
    public native int getAvailableButtonsSize();
    public native void setButtonMaxValue(Button button, int maxValue);
    public native int getButtonMaxValue(Button button);

    public native void addAvailableGameVariable(GameVariable var);

    public native void clearAvailableGameVariables();
    public native int getAvailableGameVariablesSize();

    public native void addGameArgs(String arg);
    public native void clearGameArgs();

    public native void sendGameCommand(String cmd);

    private native int getModeNative();

    public Mode getMode(){
        return Mode.values()[this.getModeNative()];
    }

    public native void setMode(Mode mode);

    public native int getTicrate();
    public native void setTicrate(int ticrate);

    public native double getGameVariable(GameVariable var);

    public native double getLivingReward();
    public native void setLivingReward(double livingReward);
    public native double getDeathPenalty();
    public native void setDeathPenalty(double deathPenalty);

    public native double getLastReward();
    public native double getTotalReward();

    public native void setViZDoomPath(String path);
    public native void setDoomGamePath(String path);
    public native void setDoomScenarioPath(String path);
    public native void setDoomMap(String map);
    public native void setDoomSkill(int skill);
    public native void setDoomConfigPath(String path);

    public native int getSeed();
    public native void setSeed(int seed);

    public native int getEpisodeStartTime();
    public native void setEpisodeStartTime(int tics);

    public native int getEpisodeTimeout();
    public native void setEpisodeTimeout(int tics);

    public native int getEpisodeTime();

    public native boolean isDepthBufferEnabled();
    public native void setDepthBufferEnabled(boolean depthBuffer);

    public native boolean isLabelsBufferEnabled();
    public native void setLabelsBufferEnabled(boolean labelsBuffer);

    public native boolean isAutomapBufferEnabled();
    public native void setAutomapBufferEnabled(boolean automapBuffer);

    public native void setAutomapMode(AutomapMode mode);
    public native void setAutomapRotate(boolean rotate);
    public native void setAutomapRenderTextures(boolean textures);

    public native void setScreenResolution(ScreenResolution resolution);
    public native void setScreenFormat(ScreenFormat format);
    public native void setRenderHud(boolean hud);
    public native void setRenderMinimalHud(boolean minimalHud);
    public native void setRenderWeapon(boolean weapon);
    public native void setRenderCrosshair(boolean crosshair);
    public native void setRenderDecals(boolean decals);
    public native void setRenderParticles(boolean particles);
    public native void setRenderEffectsSprites(boolean sprites);
    public native void setRenderMessages(boolean messages);
    public native void setRenderCorpses(boolean corpses);
    public native void setWindowVisible(boolean visibility);
    public native void setConsoleEnabled(boolean console);
    public native void setSoundEnabled(boolean sound);

    public native int getScreenWidth();
    public native int getScreenHeight();
    public native int getScreenChannels();
    public native int getScreenPitch();
    public native int getScreenSize();
    private native int getScreenFormatNative();

    public ScreenFormat getScreenFormat(){
        return ScreenFormat.values()[this.getScreenFormatNative()];
    }

}
