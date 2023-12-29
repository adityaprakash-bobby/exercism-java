package org.example;

class Badge {
    public String print(Integer id, String name, String department) {
        StringBuilder result = new StringBuilder();

        if (id != null)
            result.append(String.format("[%d] - ", id));

        result.append(String.format("%s - ", name));

        if (department == null) result.append("OWNER");
        else result.append(department.toUpperCase());

        return result.toString();

    }
}

