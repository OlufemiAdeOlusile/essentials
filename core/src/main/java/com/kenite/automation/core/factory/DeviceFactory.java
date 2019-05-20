package com.kenite.automation.core.factory;

import com.kenite.automation.core.exceptions.KeniteWebException;
import com.kenite.automation.core.inventory.DeviceInventory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author olufemi on 2019-05-16
 */
class DeviceFactory {

    private DeviceFactory() {
    }


    /**
     * Synchronized getUnusedDevice to ensure no Conflict when used in parallel
     * @param devices list of mobile devices
     * @return device
     */
    static synchronized String getUnUsedDevice(List<String> devices) {
        DeviceInventory inventory = new DeviceInventory();

        inventory.storeIfEmpty(devices);

        List<String> deviceInventory = inventory.getDeviceInventory();

        Collections.shuffle(deviceInventory);

        Optional<String> retval = deviceInventory.stream().findAny();

        if (retval.isPresent()) {
            inventory.removeUsedDevice(retval.get());
            return retval.get();
        } else {
            throw new KeniteWebException("No available Device");
        }
    }
}
