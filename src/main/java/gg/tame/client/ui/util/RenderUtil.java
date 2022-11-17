package gg.tame.client.ui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class RenderUtil {
    protected static float zero = 0.0f;

    public static void drawTexturedModalRect(float x, float y, float x2, float y2, int gay, int gay2) {
        float f5 = 0.00390625f;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, y + (float) gay2, zero).tex(x2 * f5, (y2 + (float) gay2) * f5).endVertex();
        worldrenderer.pos(x + (float) gay, y + (float) gay2, zero).tex((x2 + (float) gay) * f5, (y2 + (float) gay2) * f5).endVertex();
        worldrenderer.pos(x + (float) gay, y, zero).tex((x2 + (float) gay) * f5, y2 * f5).endVertex();
        worldrenderer.pos(x, y, zero).tex(x2 * f5, y2 * f5).endVertex();
        tessellator.draw();
    }

    public static void startMCScaledScissorBox(int x, int y, int x2, int y2, ScaledResolution scaledResolution) {
        int scaleFactor = scaledResolution.getScaleFactor();
        int n6 = y2 - y;
        int n7 = x2 - x;
        int n8 = scaledResolution.getScaledHeight() - y2;
        GL11.glScissor(x * scaleFactor, n8 * scaleFactor, n7 * scaleFactor, n6 * scaleFactor);
    }

    public static void renderIcon(ResourceLocation resourceLocation, float size, float x, float y) {
        float f4 = size * 2.0f;
        float f5 = size * 2.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        glEnable(3042);
        Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
        GL11.glBegin(7);
        GL11.glTexCoord2d(f6 / size, f7 / size);
        GL11.glVertex2d(x, y);
        GL11.glTexCoord2d(f6 / size, (f7 + size) / size);
        GL11.glVertex2d(x, y + f5);
        GL11.glTexCoord2d((f6 + size) / size, (f7 + size) / size);
        GL11.glVertex2d(x + f4, y + f5);
        GL11.glTexCoord2d((f6 + size) / size, f7 / size);
        GL11.glVertex2d(x + f4, y);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    public static void renderIcon(ResourceLocation resourceLocation, float f, float f2, float f3, float f4) {
        float f5 = f3 / 2.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        glEnable(3042);
        Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
        GL11.glBegin(7);
        GL11.glTexCoord2d(f6 / f5, f7 / f5);
        GL11.glVertex2d(f, f2);
        GL11.glTexCoord2d(f6 / f5, (f7 + f5) / f5);
        GL11.glVertex2d(f, f2 + f4);
        GL11.glTexCoord2d((f6 + f5) / f5, (f7 + f5) / f5);
        GL11.glVertex2d(f + f3, f2 + f4);
        GL11.glTexCoord2d((f6 + f5) / f5, f7 / f5);
        GL11.glVertex2d(f + f3, f2);
        GL11.glEnd();
        GL11.glDisable(3042);
    }

    public static void startScissorBox(int n, int n2, int n3, int n4, float f, int n5) {
        int n6 = n4 - n2;
        int n7 = n3 - n;
        int n8 = n5 - n4;
        GL11.glScissor((int) ((float) n * f), (int) ((float) n8 * f), (int) ((float) n7 * f), (int) ((float) n6 * f));
    }

    public static void drawRoundedRect(double d, double d2, double d3, double d4, double d5, int color) {
        int n2;
        float f = (float) (color >> 24 & 0xFF) / 255.0F;
        float f2 = (float) (color >> 16 & 0xFF) / 255.0F;
        float f3 = (float) (color >> 8 & 0xFF) / 255.0F;
        float f4 = (float) (color & 0xFF) / 255.0F;
        GL11.glPushAttrib(0);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        d *= 2.0;
        d2 *= 2.0;
        d3 *= 2.0;
        d4 *= 2.0;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GL11.glColor4f(f2, f3, f4, f);
        glEnable(2848);
        GL11.glBegin(9);
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d(d + d5 + Math.sin((double) n2 * Math.PI / 180.0) * (d5 * -1.0), d2 + d5 + Math.cos((double) n2 * Math.PI / 180.0) * (d5 * -1.0));
        }
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d(d + d5 + Math.sin((double) n2 * Math.PI / 180.0) * (d5 * -1.0), d4 - d5 + Math.cos((double) n2 * Math.PI / 180.0) * (d5 * -1.0));
        }
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d(d3 - d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5, d4 - d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5);
        }
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d(d3 - d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5, d2 + d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5);
        }
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glDisable(2848);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }

    public static void drawRoundedOutline(float x, float y, float x1, float y1, float radius, float lineWidth, int color) {
        glPushAttrib(0);
        glScaled(0.5D, 0.5D, 0.5D);
        x *= 2.0D;
        y *= 2.0D;
        x1 *= 2.0D;
        y1 *= 2.0D;
        glEnable(GL_BLEND);
        glDisable(GL_TEXTURE_2D);
        setColor(color);
        glEnable(GL_LINE_SMOOTH);
        glLineWidth(lineWidth);
        glBegin(GL_LINE_LOOP);
        int i;
        for (i = 0; i <= 90; i += 3)
            glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
        for (i = 90; i <= 180; i += 3)
            glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
        for (i = 0; i <= 90; i += 3)
            glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
        for (i = 90; i <= 180; i += 3)
            glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
        glEnd();
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glDisable(GL_LINE_SMOOTH);
        glDisable(GL_BLEND);
        glEnable(GL_TEXTURE_2D);
        glScaled(2.0D, 2.0D, 2.0D);
        glPopAttrib();
        glLineWidth(1);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void drawCircle(double d, double d2, double d3) {
        glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(6, DefaultVertexFormats.POSITION);
        worldrenderer.pos(d, d2, zero).endVertex();
        double d4 = Math.PI * 2;
        double d5 = d4 / 30.0;
        for (double d6 = -d5; d6 < d4; d6 += d5) {
            worldrenderer.pos(d + d3 * Math.cos(-d6), d2 + d3 * Math.sin(-d6), zero).endVertex();
        }
        tessellator.draw();
        glEnable(3553);
        GL11.glDisable(3042);
    }

    public static void drawCircleWithOutLine(double d, double d2, double d3, double d4, double d5, int n, double d6) {
        glEnable(3042);
        GL11.glDisable(3553);
        glEnable(2848);
        d5 = (d5 + (double) n) % (double) n;
        Tessellator tessellator = Tessellator.getInstance();
        for (double d7 = (double) 360 / (double) n * d5; d7 < 360.0 / (double) n * (d5 + d6); d7 += 1.0) {
            double d8 = d7 * Math.PI / 180.0;
            double d9 = (d7 - 1.0) * Math.PI / 180.0;
            double[] arrd = new double[]{Math.cos(d8) * d3, -Math.sin(d8) * d3, Math.cos(d9) * d3, -Math.sin(d9) * d3};
            double[] arrd2 = new double[]{Math.cos(d8) * d4, -Math.sin(d8) * d4, Math.cos(d9) * d4, -Math.sin(d9) * d4};
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            worldrenderer.begin(7, DefaultVertexFormats.POSITION);
            worldrenderer.pos(d + arrd2[0], d2 + arrd2[1], 0.0).endVertex();
            worldrenderer.pos(d + arrd2[2], d2 + arrd2[3], 0.0).endVertex();
            worldrenderer.pos(d + arrd[2], d2 + arrd[3], 0.0).endVertex();
            worldrenderer.pos(d + arrd[0], d2 + arrd[1], 0.0).endVertex();
            tessellator.draw();
        }
        glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        glEnable(3553);
    }

    public static void drawRadial(double d, double d2, double d3, double d4, double d5, double d6) {
        glEnable(3042);
        GL11.glDisable(3553);
        glEnable(2848);
        Tessellator tessellator = Tessellator.getInstance();
        for (double d7 = d5; d7 < d6; d7 += 0.5) {
            double d8 = d7 * Math.PI / 180.0;
            double d9 = (d7 - 1.0) * Math.PI / 180.0;
            double[] arrd = new double[]{Math.cos(d8) * d3, -Math.sin(d8) * d3, Math.cos(d9) * d3, -Math.sin(d9) * d3};
            double[] arrd2 = new double[]{Math.cos(d8) * d4, -Math.sin(d8) * d4, Math.cos(d9) * d4, -Math.sin(d9) * d4};
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            worldrenderer.begin(7, DefaultVertexFormats.POSITION);
            worldrenderer.pos(d + arrd2[0], d2 + arrd2[1], 0.0).endVertex();
            worldrenderer.pos(d + arrd2[2], d2 + arrd2[3], 0.0).endVertex();
            worldrenderer.pos(d + arrd[2], d2 + arrd[3], 0.0).endVertex();
            worldrenderer.pos(d + arrd[0], d2 + arrd[1], 0.0).endVertex();
            tessellator.draw();
        }
        glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        glEnable(3553);
    }

    public static void drawHorizontalLine(float f, float f2, float f3, int color) {
        if (f2 < f) {
            float f4 = f;
            f = f2;
            f2 = f4;
        }
        Gui.drawRect(f, f3, f2 + 1.0f, f3 + 1.0f, color);
    }

    public static Color getRgbValues(int color) {
        float alpha = (color >> 24 & 255) / 255F;
        float red = (color >> 16 & 255) / 255F;
        float green = (color >> 8 & 255) / 255F;
        float blue = (color & 255) / 255F;

        return new Color(red, green, blue, alpha);
    }

    public static void drawVerticalLine(float f, float f2, float f3, int color) {
        if (f3 < f2) {
            float f4 = f2;
            f2 = f3;
            f3 = f4;
        }
        Gui.drawRect(f, f2 + 1.0f, f + 1.0f, f3, color);
    }

    public static void drawRectWithOutline(float left, float top, float right, float bottom, int outlineColor, int rectColor) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        Gui.drawRect((left *= 2.0f) + 1.0f, (top *= 2.0f) + 1.0f, (right *= 2.0f) - 1.0f, (bottom *= 2.0f) - 1.0f, rectColor);
        RenderUtil.drawVerticalLine(left, top + 1.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawVerticalLine(right - 1.0f, top + 1.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 2.0f, right - 3.0f, top, outlineColor);
        RenderUtil.drawHorizontalLine(left + 2.0f, right - 3.0f, bottom - 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 1.0f, left + 1.0f, top + 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(right - 2.0f, right - 2.0f, top + 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(right - 2.0f, right - 2.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 1.0f, left + 1.0f, bottom - 2.0f, outlineColor);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }

    public static void drawGradientRectWithOutline(float left, float top, float right, float bottom, int outlineColor, int startColor, int endColor) {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        Minecraft.getMinecraft().ingameGUI.drawGradientRect((left *= 2.0f) + 1.0f, (top *= 2.0f) + 1.0f, (right *= 2.0f) - 1.0f, (bottom *= 2.0f) - 1.0f, startColor, endColor);
        RenderUtil.drawVerticalLine(left, top + 1.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawVerticalLine(right - 1.0f, top + 1.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 2.0f, right - 3.0f, top, outlineColor);
        RenderUtil.drawHorizontalLine(left + 2.0f, right - 3.0f, bottom - 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 1.0f, left + 1.0f, top + 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(right - 2.0f, right - 2.0f, top + 1.0f, outlineColor);
        RenderUtil.drawHorizontalLine(right - 2.0f, right - 2.0f, bottom - 2.0f, outlineColor);
        RenderUtil.drawHorizontalLine(left + 1.0f, left + 1.0f, bottom - 2.0f, outlineColor);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }

    public static void drawRectWithShadow(float x, float y, float x2, float y2, int color, boolean shadow) {
        if (shadow) {
            Gui.drawRect(x + 1.0F, y + 1.0F, x2 + 1.0F, y2 + 1.0F, new Color((color >> 16 & 255) / 4, (color >> 8 & 255) / 4, (color & 255) / 4, color >> 24 & 255).getRGB());
        }
        Gui.drawRect(x, y, x2, y2, color);
    }

    public static void setColor(int color) {
        float a = (color >> 24 & 0xFF) / 255.0F;
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        glColor4f(r, g, b, a);
    }

}
