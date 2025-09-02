/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee emp : employees) {
            empMap.put(emp.id, emp);  
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(empMap.get(id).id);
        int importance = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Integer empId = q.poll();
                Employee emp = empMap.get(empId);
                importance += emp.importance;
                if(!emp.subordinates.isEmpty()) {
                    for(int subId : emp.subordinates) {
                        q.add(empMap.get(subId).id);
                    }
                }
            }
        }
        return importance;
    }
}