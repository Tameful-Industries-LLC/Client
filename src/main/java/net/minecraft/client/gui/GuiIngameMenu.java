package net.minecraft.client.gui;

import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.resources.I18n;
import net.minecraft.realms.RealmsBridge;

import java.io.IOException;

public class GuiIngameMenu extends GuiScreen
{
    private int selectedButton;
    private int eventButton;
    private GuiButton modsButton;

    public void initGui()
    {
        this.selectedButton = 0;
        this.buttonList.clear();
        int n = -16;
        boolean bl = true;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + n, I18n.format("menu.returnToMenu")));
        if (!this.mc.isIntegratedServerRunning()) {
            this.buttonList.get(0).displayString = I18n.format("menu.disconnect");
        }
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24 + n, I18n.format("menu.returnToGame")));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + n, 98, 20, I18n.format("menu.options")));
        GuiButton guiButton = new GuiButton(7, this.width / 2 + 2, this.height / 4 + 96 + n, 98, 20, I18n.format("menu.shareToLan"));
        guiButton.enabled = this.mc.isSingleplayer() && !this.mc.getIntegratedServer().getPublic();
        this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 48 + n, 98, 20, I18n.format("gui.achievements")));
        this.buttonList.add(new GuiButton(6, this.width / 2 + 2, this.height / 4 + 48 + n, 98, 20, I18n.format("gui.stats")));
        if (!guiButton.enabled) {
            this.modsButton = new GuiButton(10, this.width / 2 + 2, this.height / 4 + 96 + n, 98, 20, "Mods");
            this.buttonList.add(this.modsButton);
            this.buttonList.add(new GuiButton(16, this.width / 2 - 100, this.height / 4 + 72 + n, 200, 20, "Server List"));
        } else {
            this.buttonList.add(guiButton);
            this.buttonList.add(new GuiButton(16, this.width / 2 - 100, this.height / 4 + 72 + n, 98, 20, "Server List"));
            this.modsButton = new GuiButton(10, this.width / 2 + 2, this.height / 4 + 72 + n, 98, 20, "Mods");
            this.buttonList.add(this.modsButton);
        }
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id) {
            case 16:
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            case 0:
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            case 1:
                boolean flag = this.mc.isIntegratedServerRunning();
                boolean flag1 = this.mc.isConnectedToRealms();
                button.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld(null);

                if (flag) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                } else if (flag1) {
                    RealmsBridge realmsbridge = new RealmsBridge();
                    realmsbridge.switchToRealms(new GuiMainMenu());
                } else {
                    this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
                }
            default:
                break;
            case 4:
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            case 5:
                this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            case 6:
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            case 7:
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
            case 10:
                System.out.println("aaa");
        }
    }

    public void updateScreen()
    {
        super.updateScreen();
        ++this.eventButton;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        int n3 = 600;
        int n4 = 356;
        double d = (double)Math.min(this.width, this.height) / ((double)n3 * (double)9);
        int n5 = (int)((double)n3 * d);
        int n6 = (int)((double)n4 * d);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
