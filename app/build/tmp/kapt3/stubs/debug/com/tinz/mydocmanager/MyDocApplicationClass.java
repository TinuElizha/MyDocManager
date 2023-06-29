package com.tinz.mydocmanager;

import android.app.Application;
import android.content.Context;
import dagger.hilt.android.HiltAndroidApp;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tinz/mydocmanager/MyDocApplicationClass;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class MyDocApplicationClass extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    public static final com.tinz.mydocmanager.MyDocApplicationClass.Companion Companion = null;
    private static com.tinz.mydocmanager.MyDocApplicationClass instance;
    private static android.content.Context context;
    
    public MyDocApplicationClass() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tinz/mydocmanager/MyDocApplicationClass$Companion;", "", "()V", "context", "Landroid/content/Context;", "instance", "Lcom/tinz/mydocmanager/MyDocApplicationClass;", "applicationContext", "getContext", "setContext", "", "con", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context applicationContext() {
            return null;
        }
        
        public final void setContext(@org.jetbrains.annotations.NotNull
        android.content.Context con) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
    }
}