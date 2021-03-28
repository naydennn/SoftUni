package TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    private static final double CORRECT_LOW_PRESSURE_THRESHOLD = 16;
    private static final double CORRECT_HIGH_PRESSURE_THRESHOLD = 22;
    private static final double BETWEEN_PRESSURE_THRESHOLD = 20;

    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        this.sensor =  Mockito.mock(Sensor.class);
        this.alarm = new Alarm(this.sensor);
    }


    @Test
    public void testAlarmWithHighPressureThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);

        alarm.check();
        boolean alarmOn = alarm.getAlarmOn();

        assertFalse(alarmOn);
    }

    @Test
    public void testAlarmWithLowPressureThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD);

        alarm.check();
        boolean alarmOn = alarm.getAlarmOn();

        assertFalse(alarmOn);
    }

    @Test
    public void testAlarmWithCorrectLowPressureThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(CORRECT_LOW_PRESSURE_THRESHOLD);

        alarm.check();
        boolean alarmOn = alarm.getAlarmOn();

        assertTrue(alarmOn);
    }

    @Test
    public void testAlarmWithCorrectHighPressureThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(CORRECT_HIGH_PRESSURE_THRESHOLD);

        alarm.check();
        boolean alarmOn = alarm.getAlarmOn();

        assertTrue(alarmOn);
    }

    @Test
    public void testAlarmWithBetweenValuePressureThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(BETWEEN_PRESSURE_THRESHOLD);

        alarm.check();
        boolean alarmOn = alarm.getAlarmOn();

        assertFalse(alarmOn);
    }


}