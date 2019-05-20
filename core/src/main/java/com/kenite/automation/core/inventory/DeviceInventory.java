package com.kenite.automation.core.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author olufemi on 2019-05-16
 */
public class DeviceInventory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceInventory.class);
    private static List<String> inventory = new ArrayList<>();

    public List<String> getDeviceInventory() {
        return inventory;
    }


    public void storeIfEmpty(List<String> devices) {
        if (inventory.isEmpty()) {
            inventory.addAll(devices);
            LOGGER.info("Stored all devices in Inventory");
        }
    }

    public void removeUsedDevice(String device) {
        inventory.remove(device);
        LOGGER.info("Removed device {} from Inventory", device);
    }

    public void addFreeDevice(String device) {
        inventory.add(device);
        LOGGER.info("added device {} into Inventory", device);
    }
}
