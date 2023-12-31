public class P3Tester {
	public static void main(String[] args)
    {
        QueueSystem queueSystem = new QueueSystem(5, true, false);

        String[] client1Request1Questions = {"why am i lonely"};
        Request client1Request1 = new InformationRequest("lol", 1, 1, client1Request1Questions);
        String[] client1Request2Questions = {"let me be alone"};
        Request cleint1Request2 = new InformationRequest("lmao", 1, 1, client1Request2Questions);
        Request[] client1Requests = {client1Request1, cleint1Request2};
        Client client1 = new Client("Justin", "Vu", 1960, "MALE", 1, 0, client1Requests);
        
        String[] client2Request2Questions = {"return siv"};
        Request client2Request1 = new InformationRequest("haha", 1, 1, client2Request2Questions);
        Request[] client2Requests = {client2Request1};
        Client client2 = new Client("James", "Horng", 1821, "MALE", 1, 0, client2Requests);

        System.out.println();
        Queue queue1 = new Queue("Queue1", 1);
        queue1.setClientBeingServed(client1);
        Client[] clientsInQue = {client2};
//        queue1.setClientsInQue(clientsInQue);
        Queue[] queues1 = {queue1};
        QueueSystem.setQueues(queues1);
        
        System.out.println();
        
        System.out.println("--------------------");
        System.out.println("Clock: " + QueueSystem.getClock()); //0
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientBeingServed().getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientBeingServed().getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientBeingServed().getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientBeingServed().getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsInQueue()[0].getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        
        System.out.println("--------------------");
//        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //1
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientBeingServed().getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientBeingServed().getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientBeingServed().getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientBeingServed().getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsInQueue()[0].getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        
        System.out.println("--------------------");
//        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //2
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientBeingServed().getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientBeingServed().getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientBeingServed().getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientBeingServed().getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsInQueue()[0].getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsInQueue()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();

        System.out.println("--------------------");
//        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //3
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsHistory()[0].getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientBeingServed().getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientBeingServed().getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientBeingServed().getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientBeingServed().getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();

        System.out.println("--------------------");
//        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //3
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsHistory()[0].getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientBeingServed().getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientBeingServed().getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientBeingServed().getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientBeingServed().getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientBeingServed().getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();

        System.out.println("--------------------");
//        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //3
        System.out.println("Client1 ID: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getId());
        System.out.println("Client1 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsHistory()[0].getYearOfBirth()));
        System.out.println("Client1 Gender: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getGender());
        System.out.println("Client1 Patience: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Request 2");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[0].getRequests()[1].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
        System.out.println("Client2 ID: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getId());
        System.out.println("Client2 Age: " + (2023 - QueueSystem.getQueues()[0].getClientsHistory()[1].getYearOfBirth()));
        System.out.println("Client2 Gender: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getGender());
        System.out.println("Client2 Patience: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getPatience());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[1].toString());
        System.out.println();
        System.out.println("Request 1");
        System.out.println("Description: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getRequests()[0].getDescription());
        System.out.println("Start Time: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getRequests()[0].getStartTime());
        System.out.println("End Time: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getRequests()[0].getEndTime());
        System.out.println("Completion Level: " + QueueSystem.getQueues()[0].getClientsHistory()[1].getRequests()[0].getCompletionLevel());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory()[1].getRequests()[0].getStatus());
        System.out.println(QueueSystem.getQueues()[0].getClientsHistory());
        System.out.println();
    }
}