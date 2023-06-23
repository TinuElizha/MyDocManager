package com.tinz.mydocmanager.navigation;

import androidx.compose.material.icons.Icons;
import com.tinz.mydocmanager.R;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0003\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tinz/mydocmanager/navigation/BottomBarScreen;", "", "route", "", "title", "icon", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getIcon", "()I", "getRoute", "()Ljava/lang/String;", "getTitle", "Image", "MyDoc", "Pdf", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen$Image;", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen$MyDoc;", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen$Pdf;", "app_debug"})
public abstract class BottomBarScreen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    private final int icon = 0;
    
    private BottomBarScreen(java.lang.String route, java.lang.String title, int icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final int getIcon() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tinz/mydocmanager/navigation/BottomBarScreen$Pdf;", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen;", "()V", "app_debug"})
    public static final class Pdf extends com.tinz.mydocmanager.navigation.BottomBarScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.tinz.mydocmanager.navigation.BottomBarScreen.Pdf INSTANCE = null;
        
        private Pdf() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tinz/mydocmanager/navigation/BottomBarScreen$Image;", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen;", "()V", "app_debug"})
    public static final class Image extends com.tinz.mydocmanager.navigation.BottomBarScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.tinz.mydocmanager.navigation.BottomBarScreen.Image INSTANCE = null;
        
        private Image() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tinz/mydocmanager/navigation/BottomBarScreen$MyDoc;", "Lcom/tinz/mydocmanager/navigation/BottomBarScreen;", "()V", "app_debug"})
    public static final class MyDoc extends com.tinz.mydocmanager.navigation.BottomBarScreen {
        @org.jetbrains.annotations.NotNull
        public static final com.tinz.mydocmanager.navigation.BottomBarScreen.MyDoc INSTANCE = null;
        
        private MyDoc() {
            super(null, null, 0);
        }
    }
}