package com.example.medical;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0002J\b\u00104\u001a\u00020)H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00065"}, d2 = {"Lcom/example/medical/TaskActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "dateSetListener", "Landroid/app/DatePickerDialog$OnDateSetListener;", "getDateSetListener", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "setDateSetListener", "(Landroid/app/DatePickerDialog$OnDateSetListener;)V", "db", "Lcom/example/medical/AppDatabase;", "getDb", "()Lcom/example/medical/AppDatabase;", "db$delegate", "Lkotlin/Lazy;", "finalDate", "", "getFinalDate", "()J", "setFinalDate", "(J)V", "finalTime", "getFinalTime", "setFinalTime", "labels", "Ljava/util/ArrayList;", "", "myCalendar", "Ljava/util/Calendar;", "getMyCalendar", "()Ljava/util/Calendar;", "setMyCalendar", "(Ljava/util/Calendar;)V", "timeSetListener", "Landroid/app/TimePickerDialog$OnTimeSetListener;", "getTimeSetListener", "()Landroid/app/TimePickerDialog$OnTimeSetListener;", "setTimeSetListener", "(Landroid/app/TimePickerDialog$OnTimeSetListener;)V", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveTodo", "setListener", "setTimeListener", "setUpSpinner", "updateDate", "updateTime", "app_debug"})
public final class TaskActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    public java.util.Calendar myCalendar;
    public android.app.DatePickerDialog.OnDateSetListener dateSetListener;
    public android.app.TimePickerDialog.OnTimeSetListener timeSetListener;
    private long finalDate = 0L;
    private long finalTime = 0L;
    private final java.util.ArrayList<java.lang.String> labels = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    
    public TaskActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getMyCalendar() {
        return null;
    }
    
    public final void setMyCalendar(@org.jetbrains.annotations.NotNull()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.DatePickerDialog.OnDateSetListener getDateSetListener() {
        return null;
    }
    
    public final void setDateSetListener(@org.jetbrains.annotations.NotNull()
    android.app.DatePickerDialog.OnDateSetListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.TimePickerDialog.OnTimeSetListener getTimeSetListener() {
        return null;
    }
    
    public final void setTimeSetListener(@org.jetbrains.annotations.NotNull()
    android.app.TimePickerDialog.OnTimeSetListener p0) {
    }
    
    public final long getFinalDate() {
        return 0L;
    }
    
    public final void setFinalDate(long p0) {
    }
    
    public final long getFinalTime() {
        return 0L;
    }
    
    public final void setFinalTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.medical.AppDatabase getDb() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpSpinner() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    private final void saveTodo() {
    }
    
    private final void setTimeListener() {
    }
    
    private final void updateTime() {
    }
    
    private final void setListener() {
    }
    
    private final void updateDate() {
    }
}