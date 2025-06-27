<h2>Question 1</h2>
(Topic 2) A company wants to use Amazon EC2 instances for a stable production workload that will run for 1 year. Which instance purchasing option meets these requirements MOST cost-effectively?
<pre>
A) Dedicated Hosts
B) Reserved Instances
C) On-Demand Instances
D) Spot Instances
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Reserved Instances
  
  <strong>Explanation:</strong> Reserved Instances are the instance purchasing option that offers the most cost-effective way to use Amazon EC2 instances for a stable production workload that will run for 1 year, as they provide significant discounts compared to On-Demand Instances in exchange for a commitment to use a specific amount of computing power for a period of time.
  
  <strong>Why other options are incorrect:</strong>
  - A) Dedicated Hosts are more expensive and less flexible than Reserved Instances
  - C) On-Demand Instances are more suitable for short-term, variable, and unpredictable workloads
  - D) Spot Instances are more suitable for flexible, scalable, and fault-tolerant workloads that can tolerate interruptions
</details>

<h2>Question 2</h2>
(Topic 1) Who is responsible for decommissioning end-of-life underlying storage devices that are used to host data on AWS?
<pre>
A) Customer
B) AWS
C) Account creator
D) Auditing team
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS
  
  <strong>Explanation:</strong> AWS is responsible for decommissioning end-of-life underlying storage devices that are used to host data on AWS. AWS follows strict and audited data destruction processes to ensure that customer data is not exposed to unauthorized individuals or devices when an AWS storage device reaches the end of its useful life. AWS uses techniques detailed in DoD 5220.22-M ("National Industrial Security Program Operating Manual") or NIST 800-88 ("Guidelines for Media Sanitization") to destroy data as part of the decommissioning process.
</details>

<h2>Question 3</h2>
(Topic 1) A company uses Amazon Aurora as its database service. The company wants to encrypt its databases and database backups. Which party manages the encryption of the database clusters and database snapshots, according to the AWS shared responsibility model?
<pre>
A) AWS
B) The company
C) AWS Marketplace partners
D) Third-party partners
</pre>

<details>
  <summary>Answer:</summary>
  
  A) AWS
  
  <strong>Explanation:</strong> AWS manages the encryption of the database clusters and database snapshots for Amazon Aurora, as well as the encryption keys. This is part of the AWS shared responsibility model, where AWS is responsible for the security of the cloud, and the customer is responsible for the security in the cloud. Encryption is one of the security features that AWS provides to protect the data at rest and in transit.
</details>

<h2>Question 4</h2>
(Topic 1) What is an Availability Zone?
<pre>
A) A location where users can deploy compute, storage, database, and other select AWS services where no AWS Region currently exists
B) One or more discrete data centers with redundant power, networking, and connectivity
C) One or more clusters of servers where new workloads can be deployed
D) A fast content delivery network (CDN) service that securely delivers data, videos, applications, and APIs to users globally
</pre>

<details>
  <summary>Answer:</summary>
  
  B) One or more discrete data centers with redundant power, networking, and connectivity
  
  <strong>Explanation:</strong> An Availability Zone is one or more discrete data centers with redundant power, networking, and connectivity. Availability Zones are part of the AWS global infrastructure, which consists of AWS Regions, Availability Zones, and edge locations. Availability Zones are physically separate locations within an AWS Region that are engineered to be isolated from failures and connected by low-latency, high-throughput, and highly redundant networking. Each Availability Zone contains one or more data centers that house the servers and storage devices that run AWS services. Availability Zones enable users to design and operate fault-tolerant and high-availability applications on AWS.
</details>

<h2>Question 5</h2>
(Topic 1) A company wants to establish a security layer in its VPC that will act as a firewall to control subnet traffic. Which AWS service or feature will meet this requirement?
<pre>
A) Routing tables
B) Network access control lists (network ACLs)
C) Security groups
D) Amazon GuardDuty
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Security groups
  
  <strong>Explanation:</strong> Security groups are the service or feature that meets the requirement of establishing a security layer in a VPC that will act as a firewall to control subnet traffic. Security groups are stateful firewalls that control the inbound and outbound traffic at the instance level. You can assign one or more security groups to each instance in a VPC, and specify the rules that allow or deny traffic based on the protocol, port, and source or destination. Security groups are associated with network interfaces, and therefore apply to all the instances in the subnets that use those network interfaces.
  
  <strong>Why other options are incorrect:</strong>
  - A) Routing tables are used to direct traffic between subnets and gateways, not to filter traffic
  - B) Network ACLs are stateless firewalls that control traffic at the subnet level, but they are less granular and more cumbersome to manage than security groups
  - D) Amazon GuardDuty is a threat detection service that monitors your AWS account and workloads for malicious or unauthorized activity, not a firewall service
</details>

<h2>Question 6</h2>
(Topic 1) A company wants to deploy and manage a Docker-based application on AWS. Which solution meets these requirements with the LEAST amount of operational overhead?
<pre>
A) An open-source Docker orchestrator on Amazon EC2 instances
B) AWS AppSync
C) Amazon Elastic Container Registry (Amazon ECR)
D) Amazon Elastic Container Service (Amazon ECS)
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon Elastic Container Service (Amazon ECS)
  
  <strong>Explanation:</strong> Amazon Elastic Container Service (Amazon ECS) is a solution that meets the requirements of deploying and managing a Docker-based application on AWS with the least amount of operational overhead. Amazon ECS is a fully managed container orchestration service that makes it easy to run, scale, and secure Docker container applications on AWS. Amazon ECS eliminates the need for you to install, operate, and scale your own cluster management infrastructure. With simple API calls, you can launch and stop container-enabled applications, query the complete state of your cluster, and access many familiar features like security groups, Elastic Load Balancing, EBS volumes, and IAM roles.
</details>

<h2>Question 7</h2>
(Topic 1) A company needs to store data across multiple Availability Zones in an AWS Region. The data will not be accessed regularly but must be immediately retrievable. Which Amazon Elastic File System (Amazon EFS) storage class meets these requirements MOST cost effectively?
<pre>
A) EFS Standard
B) EFS Standard-Infrequent Access (EFS Standard-IA)
C) EFS One Zone
D) EFS One Zone-Infrequent Access (EFS One Zone-IA)
</pre>

<details>
  <summary>Answer:</summary>
  
  B) EFS Standard-Infrequent Access (EFS Standard-IA)
  
  <strong>Explanation:</strong> EFS Standard-Infrequent Access (EFS Standard-IA) is the storage class that meets the requirements of storing data across multiple Availability Zones in an AWS Region, that will not be accessed regularly but must be immediately retrievable, most cost-effectively. EFS Standard-IA is designed for files that are accessed less frequently, but still require the same high performance, low latency, and high availability as EFS Standard. EFS Standard-IA has a lower storage cost than EFS Standard, but charges a small additional fee for each access.
  
  <strong>Why other options are incorrect:</strong>
  - A) EFS Standard has higher storage costs for infrequently accessed data
  - C) EFS One Zone stores data in a single Availability Zone, which reduces availability and durability
  - D) EFS One Zone-IA stores data in a single Availability Zone, which reduces availability and durability
</details>

<h2>Question 8</h2>
(Topic 1) According to the AWS shared responsibility model, which of the following are AWS responsibilities? (Select TWO.)
<pre>
A) Network infrastructure and virtualization of infrastructure
B) Security of application data
C) Guest operating systems
D) Physical security of hardware
E) Credentials and policies
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Network infrastructure and virtualization of infrastructure
  D) Physical security of hardware
  
  <strong>Explanation:</strong> The correct answers are A and D because network infrastructure and virtualization of infrastructure and physical security of hardware are AWS responsibilities according to the AWS shared responsibility model. The AWS shared responsibility model is a framework that defines the division of responsibilities between AWS and the customer for security and compliance. AWS is responsible for the security of the cloud, which includes the global infrastructure, such as the regions, availability zones, and edge locations; the hardware, software, networking, and facilities that run the AWS services; and the virtualization layer that separates the customer instances and storage.
  
  <strong>Why other options are incorrect:</strong>
  - B) Security of application data is a customer responsibility
  - C) Guest operating systems are a customer responsibility
  - E) Credentials and policies are a customer responsibility
</details>

<h2>Question 9</h2>
(Topic 1) Which database engine is compatible with Amazon RDS?
<pre>
A) Apache Cassandra
B) MongoDB
C) Neo4j
D) PostgreSQL
</pre>

<details>
  <summary>Answer:</summary>
  
  D) PostgreSQL
  
  <strong>Explanation:</strong> Amazon RDS supports six database engines: Amazon Aurora, MySQL, MariaDB, PostgreSQL, Oracle, and SQL Server. Apache Cassandra, MongoDB, and Neo4j are not compatible with Amazon RDS. Therefore, the correct answer is D.
</details>

<h2>Question 10</h2>
(Topic 1) A company needs to identify the last time that a specific user accessed the AWS Management Console. Which AWS service will provide this information?
<pre>
A) Amazon Cognito
B) AWS CloudTrail
C) Amazon Inspector
D) Amazon GuardDuty
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS CloudTrail
  
  <strong>Explanation:</strong> AWS CloudTrail is the service that will provide the information about the last time that a specific user accessed the AWS Management Console. AWS CloudTrail is a service that records the API calls and events made by or on behalf of your AWS account. You can use AWS CloudTrail to view, search, and download the history of AWS console sign-in events, which include the user name, date, time, source IP address, and other details of the sign-in activity.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Cognito is a service that provides user authentication and authorization for web and mobile applications
  - C) Amazon Inspector is a service that assesses the security and compliance of your applications running on AWS
  - D) Amazon GuardDuty is a service that monitors your AWS account and workloads for malicious or unauthorized activity
</details>

<h2>Question 11</h2>
(Topic 1) Which AWS Well-Architected Framework concept represents a system's ability to remain functional when the system encounters operational problems?
<pre>
A) Consistency
B) Elasticity
C) Durability
D) Latency
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Elasticity
  
  <strong>Explanation:</strong> The AWS Well-Architected Framework is a set of best practices and guidelines for designing and operating systems in the cloud. The framework consists of five pillars: operational excellence, security, reliability, performance efficiency, and cost optimization. The concept of elasticity represents a system's ability to adapt to changes in demand by scaling resources up or down automatically.
</details>

<h2>Question 12</h2>
(Topic 1) Which task requires the use of AWS account root user credentials?
<pre>
A) The deletion of IAM users
B) The change to a different AWS Support plan
C) The creation of an organization in AWS Organizations
D) The deletion of Amazon EC2 instances
</pre>

<details>
  <summary>Answer:</summary>
  
  C) The creation of an organization in AWS Organizations
  
  <strong>Explanation:</strong> The creation of an organization in AWS Organizations requires the use of AWS account root user credentials. The AWS account root user is the email address that was used to create the AWS account. The root user has complete access to all AWS services and resources in the account, and can perform sensitive tasks such as changing the account settings, closing the account, or creating an organization. The root user credentials should be used sparingly and securely, and only for tasks that cannot be performed by IAM users or roles.
</details>

<h2>Question 13</h2>
(Topic 1) A company wants to use the AWS Cloud as an offsite backup location for its on-premises infrastructure. Which AWS service will meet this requirement MOST cost-effectively?
<pre>
A) Amazon S3
B) Amazon Elastic File System (Amazon EFS)
C) Amazon FSx
D) Amazon Elastic Block Store (Amazon EBS)
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Amazon S3
  
  <strong>Explanation:</strong> Amazon S3 is the most cost-effective service for storing offsite backups of on-premises infrastructure. Amazon S3 offers low-cost, durable, and scalable storage that can be accessed from anywhere over the internet. Amazon S3 also supports lifecycle policies, versioning, encryption, and cross-region replication to optimize the backup and recovery process.
  
  <strong>Why other options are incorrect:</strong>
  - B) Amazon EFS is more suitable for storing data that requires high performance, low latency, and frequent access
  - C) Amazon FSx is more suitable for storing data that requires high performance, low latency, and frequent access
  - D) Amazon EBS is more suitable for storing data that requires high performance, low latency, and frequent access
</details>

<h2>Question 14</h2>
(Topic 1) Which AWS services or features can control VPC traffic? (Select TWO.)
<pre>
A) Security groups
B) AWS Direct Connect
C) Amazon GuardDuty
D) Network ACLs
E) Amazon Connect
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Security groups
  D) Network ACLs
  
  <strong>Explanation:</strong> The AWS services or features that can control VPC traffic are security groups and network ACLs. Security groups are stateful firewalls that control the inbound and outbound traffic at the instance level. You can assign one or more security groups to each instance in a VPC, and specify the rules that allow or deny traffic based on the protocol, port, and source or destination. Network ACLs are stateless firewalls that control the inbound and outbound traffic at the subnet level. You can associate one network ACL with each subnet in a VPC, and specify the rules that allow or deny traffic based on the protocol, port, and source or destination.
  
  <strong>Why other options are incorrect:</strong>
  - B) AWS Direct Connect is a service that establishes a dedicated network connection between your premises and AWS
  - C) Amazon GuardDuty is a service that monitors your AWS account and workloads for malicious or unauthorized activity
  - E) Amazon Connect is a service that provides a cloud-based contact center solution
</details>

<h2>Question 15</h2>
(Topic 1) Which of the following is an advantage of AWS Cloud computing?
<pre>
A) Trade security for elasticity
B) Trade operational excellence for agility
C) Trade fixed expenses for variable expenses
D) Trade elasticity for performance
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Trade fixed expenses for variable expenses
  
  <strong>Explanation:</strong> The correct answer is C because AWS Cloud computing allows customers to trade fixed expenses for variable expenses. This means that customers only pay for the resources they use, and can scale up or down as needed.
  
  <strong>Why other options are incorrect:</strong>
  - A) Trade security for elasticity means that customers have to compromise on the protection of their data and applications in order to adjust their capacity quickly
  - B) Trade operational excellence for agility means that customers have to sacrifice the quality and reliability of their operations in order to respond to changing needs faster
  - D) Trade elasticity for performance means that customers have to limit their ability to scale up or down in order to achieve higher speed and efficiency
</details>

<h2>Question 16</h2>
(Topic 1) Which AWS service aggregates, organizes, and prioritizes security alerts and findings from multiple AWS services?
<pre>
A) Amazon Detective
B) Amazon Inspector
C) Amazon Macie
D) AWS Security Hub
</pre>

<details>
  <summary>Answer:</summary>
  
  D) AWS Security Hub
  
  <strong>Explanation:</strong> The correct answer is D because AWS Security Hub is a service that aggregates, organizes, and prioritizes security alerts and findings from multiple AWS services, such as Amazon GuardDuty, Amazon Inspector, Amazon Macie, AWS Firewall Manager, and AWS IAM Access Analyzer.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Detective is a service that helps users analyze and visualize security data to investigate and remediate potential issues
  - B) Amazon Inspector is a service that helps users find security vulnerabilities and deviations from best practices in their Amazon EC2 instances
  - C) Amazon Macie is a service that helps users discover, classify, and protect sensitive data stored in Amazon S3
</details>

<h2>Question 17</h2>
(Topic 1) Which AWS service or feature can be used to estimate costs before deployment?
<pre>
A) AWS Free Tier
B) AWS Pricing Calculator
C) AWS Billing and Cost Management
D) AWS Cost and Usage Report
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Pricing Calculator
  
  <strong>Explanation:</strong> AWS Pricing Calculator can be used to estimate costs before deployment. AWS Pricing Calculator is a tool that helps the user to compare the cost of AWS services for different use cases and configurations. The user can create estimates for various AWS services, such as Amazon EC2, Amazon S3, Amazon RDS, and more. The user can also adjust the parameters, such as region, instance type, storage size, and duration, to see how they affect the cost. AWS Pricing Calculator provides a detailed breakdown of the estimated cost, as well as a summary of the key drivers of the cost.
</details>

<h2>Question 18</h2>
(Topic 1) A company needs to migrate all of its development teams to a cloud-based integrated development environment (IDE). Which AWS service should the company use?
<pre>
A) AWS CodeBuild
B) AWS Cloud9
C) AWS OpsWorks
D) AWS Cloud Development Kit (AWS CDK)
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Cloud9
  
  <strong>Explanation:</strong> The correct answer is B because AWS Cloud9 is an AWS service that enables users to run their existing custom, nonproduction workloads in the AWS Cloud quickly and cost-effectively. AWS Cloud9 is a cloud-based integrated development environment (IDE) that allows users to write, run, and debug code from a web browser. AWS Cloud9 supports multiple programming languages, such as Python, Java, Node.js, and more. AWS Cloud9 also provides users with a terminal that can access AWS services and resources, such as Amazon EC2 instances, AWS Lambda functions, and AWS CloudFormation stacks.
  
  <strong>Why other options are incorrect:</strong>
  - A) AWS CodeBuild is an AWS service that enables users to compile, test, and package their code for deployment
  - C) AWS OpsWorks is an AWS service that enables users to configure and manage their applications using Chef or Puppet
  - D) AWS Cloud Development Kit (AWS CDK) is an AWS service that enables users to define and provision their cloud infrastructure using familiar programming languages
</details>

<h2>Question 19</h2>
(Topic 1) Which feature of the AWS Cloud gives users the ability to pay based on current needs rather than forecasted needs?
<pre>
A) AWS Budgets
B) Pay-as-you-go pricing
C) Volume discounts
D) Savings Plans
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Pay-as-you-go pricing
  
  <strong>Explanation:</strong> Pay-as-you-go pricing is the feature of the AWS Cloud that gives users the ability to pay based on current needs rather than forecasted needs. Pay-as-you-go pricing means that users only pay for the AWS services and resources they use, without any upfront or long-term commitments. This allows users to scale up or down their usage depending on their changing business requirements, and avoid paying for idle or unused capacity. Pay-as-you-go pricing also enables users to benefit from the economies of scale and lower costs of AWS as they grow their business.
</details>

<h2>Question 39</h2>
(Topic 1) A company has been storing monthly reports in an Amazon S3 bucket. The company exports the report data into comma-separated values (.csv) files. A developer wants to write a simple query that can read all of these files and generate a summary report. Which AWS service or feature should the developer use to meet these requirements with the LEAST amount of operational overhead?
<pre>
A) Amazon S3 Select
B) Amazon Athena
C) Amazon Redshift
D) Amazon EC2
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Amazon Athena
  
  <strong>Explanation:</strong> Amazon Athena is the AWS service that the developer should use to write a simple query that can read all of the .csv files stored in an Amazon S3 bucket and generate a summary report. Amazon Athena is an interactive query service that allows users to analyze data in Amazon S3 using standard SQL. Amazon Athena does not require any server setup or management, and users only pay for the queries they run. Amazon Athena can handle various data formats, including .csv, and can integrate with other AWS services such as Amazon QuickSight for data visualization.
</details>

<h2>Question 44</h2>
(Topic 1) Which of the following describes an AWS Region?
<pre>
A) A specific location within a geographic area that provides high availability
B) A set of data centers spanning multiple countries
C) A global picture of a user's cloud computing environment
D) A collection of databases that can be accessed from a specific geographic area only
</pre>

<details>
  <summary>Answer:</summary>
  
  A) A specific location within a geographic area that provides high availability
  
  <strong>Explanation:</strong> An AWS Region is a specific location within a geographic area that provides high availability. An AWS Region consists of two or more Availability Zones, which are isolated locations within the same Region. Each Availability Zone has independent power, cooling, and physical security, and is connected to the other Availability Zones in the same Region by low-latency, high-throughput, and highly redundant networking. AWS services are available in multiple Regions around the world, allowing the user to choose where to run their applications and store their data.
</details>

<h2>Question 45</h2>
(Topic 1) Which AWS service or tool can be used to consolidate payments for a company with multiple AWS accounts?
<pre>
A) AWS Cost and Usage Report
B) AWS Organizations
C) Cost Explorer
D) AWS Budgets
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Organizations
  
  <strong>Explanation:</strong> AWS Organizations is an account management service that enables you to consolidate multiple AWS accounts into an organization that you create and centrally manage. AWS Organizations includes consolidated billing and account management capabilities that enable you to better meet the budgetary, security, and compliance needs of your business.
</details>

<h2>Question 47</h2>
(Topic 1) Which AWS feature or resource is a deployable Amazon EC2 instance template that is prepackaged with software and security requirements?
<pre>
A) Amazon Elastic Block Store (Amazon EBS) volume
B) AWS CloudFormation template
C) Amazon Elastic Block Store (Amazon EBS) snapshot
D) Amazon Machine Image (AMI)
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon Machine Image (AMI)
  
  <strong>Explanation:</strong> An Amazon Machine Image (AMI) is a deployable Amazon EC2 instance template that is prepackaged with software and security requirements. It provides the information required to launch an instance, which is a virtual server in the cloud. You can use an AMI to launch as many instances as you need. You can also create your own custom AMIs or use AMIs shared by other AWS users.
</details>

<h2>Question 50</h2>
(Topic 1) Which of the following is an advantage that users experience when they move on-premises workloads to the AWS Cloud?
<pre>
A) Elimination of expenses for running and maintaining data centers
B) Price discounts that are identical to discounts from hardware providers
C) Distribution of all operational controls to AWS
D) Elimination of operational expenses
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Elimination of expenses for running and maintaining data centers
  
  <strong>Explanation:</strong> The advantage that users experience when they move on-premises workloads to the AWS Cloud is: elimination of expenses for running and maintaining data centers. By moving on-premises workloads to the AWS Cloud, users can reduce or eliminate the costs associated with owning and operating physical servers, storage, network equipment, and facilities. These costs include hardware purchase, maintenance, repair, power, cooling, security, and staff. Users can also benefit from the pay-as-you-go pricing model of AWS, which allows them to pay only for the resources they use, and scale up or down as needed.
</details>

<h2>Question 55</h2>
(Topic 1) Which of the following is a benefit of decoupling an AWS Cloud architecture?
<pre>
A) Reduced latency
B) Ability to upgrade components independently
C) Decreased costs
D) Fewer components to manage
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Ability to upgrade components independently
  
  <strong>Explanation:</strong> A benefit of decoupling an AWS Cloud architecture is the ability to upgrade components independently. Decoupling is a way of designing systems to reduce interdependencies and minimize the impact of changes. Decoupling allows components to interact with each other through well-defined interfaces, rather than direct references. This reduces the risk of failures and errors propagating across the system, and enables greater scalability, availability, and maintainability. By decoupling an AWS Cloud architecture, the user can upgrade or modify one component without affecting the other components.
</details>

<h2>Question 60</h2>
(Topic 1) Which AWS service uses a combination of publishers and subscribers?
<pre>
A) AWS Lambda
B) Amazon Simple Notification Service (Amazon SNS)
C) Amazon CloudWatch
D) AWS CloudFormation
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Amazon Simple Notification Service (Amazon SNS)
  
  <strong>Explanation:</strong> Amazon Simple Notification Service (Amazon SNS) is a service that provides fully managed pub/sub messaging. Pub/sub messaging is a pattern that uses a combination of publishers and subscribers. Publishers are entities that produce messages and send them to topics. Subscribers are entities that receive messages from topics. Topics are logical access points that act as communication channels between publishers and subscribers. Amazon SNS enables applications to decouple, scale, and coordinate the delivery of messages to multiple endpoints, such as email, SMS, mobile push notifications, Lambda functions, SQS queues, and HTTP/S endpoints.
</details>

<h2>Question 65</h2>
(Topic 3) Which task can only an AWS account root user perform?
<pre>
A) Changing the AWS Support plan
B) Deleting AWS resources
C) Creating an Amazon EC2 instance key pair
D) Configuring AWS WAF
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Changing the AWS Support plan
  
  <strong>Explanation:</strong> The AWS account root user is the email address that you use to sign up for AWS. The root user has complete access to all AWS services and resources in the account. The root user can perform tasks that only the root user can do, such as changing the AWS Support plan, closing the account, and restoring IAM user permissions.
</details>

<h2>Question 69</h2>
(Topic 3) A company wants to grant users in one AWS account access to resources in another AWS account. The users do not currently have permission to access the resources. Which AWS service will meet this requirement?
<pre>
A) IAM group
B) IAM role
C) IAM tag
D) IAM Access Analyzer
</pre>

<details>
  <summary>Answer:</summary>
  
  B) IAM role
  
  <strong>Explanation:</strong> IAM roles are a way to delegate access to resources in different AWS accounts. IAM roles allow users to assume a set of permissions for a limited time without having to create or share long-term credentials. IAM roles can be used to grant cross-account access by creating a trust relationship between the accounts and specifying the permissions that the role can perform. Users can then switch to the role and access the resources in the other account using temporary security credentials provided by the role.
</details>

<h2>Question 70</h2>
(Topic 3) Which AWS service or tool helps users visualize, understand, and manage spending and usage over time?
<pre>
A) AWS Organizations
B) AWS Pricing Calculator
C) AWS Cost Explorer
D) AWS Service Catalog
</pre>

<details>
  <summary>Answer:</summary>
  
  C) AWS Cost Explorer
  
  <strong>Explanation:</strong> AWS Cost Explorer is the AWS service or tool that helps users visualize, understand, and manage spending and usage over time. AWS Cost Explorer is a web-based interface that allows users to access interactive graphs and tables that display their AWS costs and usage data. Users can create custom reports that analyze cost and usage data by various dimensions, such as service, region, account, tag, and more. Users can also view historical data for up to the last 12 months, forecast future costs for up to the next 12 months, and get recommendations for cost optimization. AWS Cost Explorer also provides preconfigured views that show common cost and usage scenarios, such as monthly spend by service, daily spend by linked account, and Reserved Instance utilization.
</details>

<h2>Question 75</h2>
(Topic 3) Which VPC component provides a layer of security at the subnet level?
<pre>
A) Security groups
B) Network ACLs
C) NAT gateways
D) Route tables
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Network ACLs
  
  <strong>Explanation:</strong> Network ACLs are a feature that provide a layer of security at the subnet level by acting as a firewall to control traffic in and out of one or more subnets. Network ACLs can be configured with rules that allow or deny traffic based on the source and destination IP addresses, ports, and protocols.
  
  <strong>Why other options are incorrect:</strong>
  - A) Security groups provide a layer of security at the instance level by acting as a firewall to control traffic to and from one or more instances
  - C) NAT gateways enable instances in a private subnet to connect to the internet or other AWS services, but prevent the internet from initiating a connection with those instances
  - D) Route tables determine where network traffic from a subnet or gateway is directed
</details>

<h2>Question 78</h2>
(Topic 3) A company wants to set up a high-speed connection between its data center and its applications that run on AWS. The company must not transfer data over the internet. Which action should the company take to meet these requirements?
<pre>
A) Transfer data to AWS by using AWS Snowball
B) Transfer data to AWS by using AWS Storage Gateway
C) Set up a VPN connection between the data center and an AWS Region
D) Set up an AWS Direct Connect connection between the company network and AWS
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Set up an AWS Direct Connect connection between the company network and AWS
  
  <strong>Explanation:</strong> AWS Direct Connect is a cloud service solution that makes it easy to establish a dedicated network connection from a customer's premises to AWS. AWS Direct Connect does not involve the public internet, and therefore can reduce network costs, increase bandwidth throughput, and provide a more consistent network experience than internet-based connections.
  
  <strong>Why other options are incorrect:</strong>
  - A) AWS Snowball is a petabyte-scale data transport service that uses secure devices to transfer large amounts of data into and out of the AWS Cloud
  - B) AWS Storage Gateway is a hybrid cloud storage service that gives customers on-premises access to virtually unlimited cloud storage
  - C) A VPN connection enables customers to establish a secure and private connection between their network and AWS, but still uses the internet
</details>

<h2>Question 81</h2>
(Topic 3) Which AWS service or feature gives users the ability to capture information about network traffic in a VPC?
<pre>
A) VPC Flow Logs
B) Amazon Inspector
C) VPC route tables
D) AWS CloudTrail
</pre>

<details>
  <summary>Answer:</summary>
  
  A) VPC Flow Logs
  
  <strong>Explanation:</strong> VPC Flow Logs is a feature that enables you to capture information about the IP traffic going to and from network interfaces in your VPC. Flow log data can be published to Amazon CloudWatch Logs, Amazon S3, or Amazon Kinesis Data Firehose. You can use VPC Flow Logs to diagnose network issues, monitor traffic patterns, detect security anomalies, and comply with auditing requirements.
</details>

<h2>Question 82</h2>
(Topic 3) Which AWS Cloud benefit describes the ability to acquire resources as they are needed and release resources when they are no longer needed?
<pre>
A) Economies of scale
B) Elasticity
C) Agility
D) Security
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Elasticity
  
  <strong>Explanation:</strong> The AWS Cloud benefit that describes the ability to acquire resources as they are needed and release resources when they are no longer needed is elasticity. Elasticity means that users can quickly add and remove resources to match the demand of their applications, and only pay for what they use. Elasticity enables users to handle unpredictable workloads, reduce costs, and improve performance.
  
  <strong>Why other options are incorrect:</strong>
  - A) Economies of scale is another benefit of the AWS Cloud, but does not describe the specific ability of acquiring and releasing resources on demand
  - C) Agility is another benefit of the AWS Cloud, but does not describe the specific ability of acquiring and releasing resources on demand
  - D) Security is another benefit of the AWS Cloud, but does not describe the specific ability of acquiring and releasing resources on demand
</details>

<h2>Question 85</h2>
(Topic 3) Which AWS Cloud deployment model uses AWS Outposts as part of the application deployment infrastructure?
<pre>
A) On-premises
B) Serverless
C) Cloud-native
D) Hybrid
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Hybrid
  
  <strong>Explanation:</strong> AWS Outposts is a fully managed service that extends AWS infrastructure, services, APIs, and tools to virtually any datacenter, co-location space, or on-premises facility for a truly consistent hybrid experience. AWS Outposts enables you to run AWS services in your on-premises data center.
</details>

<h2>Question 89</h2>
(Topic 3) A company is assessing its AWS Business Support plan to determine if the plan still meets the company's needs. The company is considering switching to AWS Enterprise Support. Which additional benefit will the company receive with AWS Enterprise Support?
<pre>
A) A full set of AWS Trusted Advisor checks
B) Phone, email, and chat access to cloud support engineers 24 hours a day, 7 days a week
C) A designated technical account manager (TAM) to assist in monitoring and optimization
D) A consultative review and architecture guidance for the company's applications
</pre>

<details>
  <summary>Answer:</summary>
  
  C) A designated technical account manager (TAM) to assist in monitoring and optimization
  
  <strong>Explanation:</strong> The additional benefit that the company will receive with AWS Enterprise Support is a designated technical account manager (TAM) to assist in monitoring and optimization. A TAM is a dedicated point of contact who works with the customer to understand their use cases, applications, and goals, and provides proactive guidance and best practices to help them optimize their AWS environment. A TAM also helps the customer with case management, escalations, service updates, and feature requests.
  
  <strong>Why other options are incorrect:</strong>
  - A) A full set of AWS Trusted Advisor checks is available for customers with Business, Enterprise On-Ramp, or Enterprise Support plans
  - B) Phone, email, and chat access to cloud support engineers 24/7 is available for customers with Business, Enterprise On-Ramp, or Enterprise Support plans
  - D) A consultative review and architecture guidance for the company's applications is available for customers with Enterprise On-Ramp or Enterprise Support plans
</details>

<h2>Question 94</h2>
(Topic 2) A company wants to migrate its application to AWS. The company wants to replace upfront expenses with variable payment that is based on usage. What should the company do to meet these requirements?
<pre>
A) Use pay-as-you-go pricing
B) Purchase Reserved Instances
C) Pay less by using more
D) Rightsize instances
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Use pay-as-you-go pricing
  
  <strong>Explanation:</strong> Pay-as-you-go pricing is one of the main benefits of AWS. With pay-as-you-go pricing, you pay only for what you use, when you use it. There are no long-term contracts, termination fees, or complex licensing. You replace upfront expenses with lower variable costs and pay only for the resources you consume.
</details>

<h2>Question 95</h2>
(Topic 2) Which design principles should a company apply to AWS Cloud workloads to maximize sustainability and minimize environmental impact? (Select TWO.)
<pre>
A) Maximize utilization of Amazon EC2 instances
B) Minimize utilization of Amazon EC2 instances
C) Minimize usage of managed services
D) Force frequent application reinstallations by users
E) Reduce the need for users to reinstall applications
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Maximize utilization of Amazon EC2 instances
  E) Reduce the need for users to reinstall applications
  
  <strong>Explanation:</strong> To maximize sustainability and minimize environmental impact, a company should apply the following design principles to AWS Cloud workloads: maximize utilization of Amazon EC2 instances and reduce the need for users to reinstall applications. Maximizing utilization of Amazon EC2 instances means that the company can optimize the performance and efficiency of their compute resources, and avoid wasting energy and money on idle or underutilized instances. The company can use features such as Amazon EC2 Auto Scaling, Amazon EC2 Spot Instances, and AWS Compute Optimizer to automatically adjust the number and type of instances based on demand, cost, and performance. Reducing the need for users to reinstall applications means that the company can minimize the amount of data and bandwidth required to deliver their applications to users, and avoid unnecessary downloads and updates that consume energy and resources.
  
  <strong>Why other options are incorrect:</strong>
  - B) Minimizing utilization of Amazon EC2 instances would reduce the performance and efficiency of the compute resources
  - C) Minimizing usage of managed services would increase the operational overhead and responsibility of the company
  - D) Forcing frequent application reinstallations by users would increase the amount of data and bandwidth required to deliver the applications to users
</details>

<h2>Question 96</h2>
(Topic 1) Which AWS solution provides the ability for a company to run AWS services in the company's on-premises data center?
<pre>
A) AWS Direct Connect
B) AWS Outposts
C) AWS Systems Manager hybrid activations
D) AWS Storage Gateway
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Outposts
  
  <strong>Explanation:</strong> AWS Outposts is a fully managed service that extends AWS infrastructure, services, APIs, and tools to virtually any datacenter, co-location space, or on-premises facility for a truly consistent hybrid experience. AWS Outposts enables you to run AWS services in your on-premises data center.
</details>

<h2>Question 102</h2>
(Topic 2) Which AWS service is used to temporarily provide federated security credentials to a user?
<pre>
A) Amazon GuardDuty
B) AWS Simple Token Service (AWS STS)
C) AWS Secrets Manager
D) AWS Certificate Manager
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Simple Token Service (AWS STS)
  
  <strong>Explanation:</strong> The AWS service that is used to temporarily provide federated security credentials to a user is AWS Security Token Service (AWS STS). AWS STS is a service that enables customers to request temporary, limited-privilege credentials for AWS Identity and Access Management (IAM) users or for users that they authenticate (federated users). The company can use AWS STS to grant federated users access to AWS resources without creating permanent IAM users or sharing long-term credentials.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon GuardDuty is a threat detection service that monitors for malicious activity and unauthorized behavior across the AWS accounts and resources
  - C) AWS Secrets Manager is a service that helps customers manage and rotate secrets, such as database credentials, API keys, and passwords
  - D) AWS Certificate Manager is a service that helps customers provision, manage, and deploy public and private SSL/TLS certificates
</details>

<h2>Question 104</h2>
(Topic 2) A company has a compliance requirement to record and evaluate configuration changes, as well as perform remediation actions on AWS resources. Which AWS service should the company use?
<pre>
A) AWS Config
B) AWS Secrets Manager
C) AWS CloudTrail
D) AWS Trusted Advisor
</pre>

<details>
  <summary>Answer:</summary>
  
  A) AWS Config
  
  <strong>Explanation:</strong> AWS Config is a service that enables you to assess, audit, and evaluate the configurations of your AWS resources. AWS Config continuously monitors and records your AWS resource configurations and allows you to automate the evaluation of recorded configurations against desired configurations. With AWS Config, you can review changes in configurations and relationships between AWS resources, dive into detailed resource configuration histories, and determine your overall compliance against the configurations specified in your internal guidelines. This can help you simplify compliance auditing, security analysis, change management, and operational troubleshooting.
</details>

<h2>Question 105</h2>
(Topic 2) A company wants its Amazon EC2 instances to share the same geographic area but use redundant underlying power sources. Which solution will meet these requirements?
<pre>
A) Use EC2 instances across multiple Availability Zones in the same AWS Region
B) Use Amazon CloudFront as the database for the EC2 instances
C) Use EC2 instances in the same edge location and the same Availability Zone
D) Use EC2 instances in AWS OpsWorks stacks in different AWS Regions
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Use EC2 instances across multiple Availability Zones in the same AWS Region
  
  <strong>Explanation:</strong> Using EC2 instances across multiple Availability Zones in the same AWS Region is a solution that meets the requirements of sharing the same geographic area but using redundant underlying power sources. Availability Zones are isolated locations within an AWS Region that have independent power, cooling, and networking. Each Availability Zone has one or more data centers that host the physical servers and storage devices that run the AWS services. By launching EC2 instances in different Availability Zones, users can increase the fault tolerance and availability of their applications.
  
  <strong>Why other options are incorrect:</strong>
  - B) Amazon CloudFront is a content delivery network (CDN) service that speeds up the delivery of web content and media to end users by caching it at the edge locations closer to them. It is not a database service
  - C) Edge locations are sites that are part of the Amazon CloudFront network and are located in many cities around the world. They are not the same as Availability Zones
  - D) AWS OpsWorks is a configuration management service that allows users to automate the deployment and management of applications using Chef or Puppet
</details>

<h2>Question 106</h2>
(Topic 2) Which AWS service can defend against DDoS attacks?
<pre>
A) AWS Firewall Manager
B) AWS Shield Standard
C) AWS WAF
D) Amazon Inspector
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Shield Standard
  
  <strong>Explanation:</strong> AWS Shield Standard is a service that provides protection against Distributed Denial of Service (DDoS) attacks for all AWS customers at no additional charge. It automatically detects and mitigates the most common and frequently occurring network and transport layer DDoS attacks that target AWS resources, such as Amazon EC2 instances, Elastic Load Balancers, Amazon CloudFront distributions, and Amazon Route 53 hosted zones.
  
  <strong>Why other options are incorrect:</strong>
  - A) AWS Firewall Manager is a service that allows users to centrally configure and manage firewall rules across their AWS accounts and resources
  - C) AWS WAF is a web application firewall that helps protect web applications from common web exploits, such as SQL injection, cross-site scripting, and bot attacks
  - D) Amazon Inspector is an automated security assessment service that helps improve the security and compliance of applications deployed on AWS
</details>

<h2>Question 115</h2>
(Topic 2) Which AWS service provides the SIMPLEST way for the company to establish a website on AWS?
<pre>
A) Amazon Elastic File System (Amazon EFS)
B) AWS Elastic Beanstalk
C) AWS Lambda
D) Amazon Lightsail
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon Lightsail
  
  <strong>Explanation:</strong> Amazon Lightsail is an easy-to-use cloud platform that offers you everything needed to build an application or website, plus a cost-effective, monthly plan. Whether you're new to the cloud or looking to get on the cloud quickly with AWS infrastructure you trust, we've got you covered. Lightsail provides the simplest way for the company to establish a website on AWS.
</details>

<h2>Question 120</h2>
(Topic 2) A company is running an application on AWS. The company wants to identify and prevent the accidental exposure of data. Which AWS service or feature will meet these requirements?
<pre>
A) Amazon GuardDuty
B) Network ACL
C) AWS WAF
D) AWS Network Firewall
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Amazon GuardDuty
  
  <strong>Explanation:</strong> Amazon GuardDuty is a threat detection service that continuously monitors for malicious activity and unauthorized behavior to protect your AWS accounts, workloads, and data stored in Amazon S3. With the cloud, the collection and aggregation of account and network activities is simplified, but it can be time consuming for security teams to continuously analyze event log data for potential threats. With GuardDuty, you can automate anomaly detection and get actionable findings to help you protect your AWS resources.
</details>

<h2>Question 121</h2>
(Topic 2) A company needs to design a solution for the efficient use of compute resources for an enterprise workload. The company needs to make informed decisions as its technology needs evolve. Which pillar of the AWS Well-Architected Framework do these requirements represent?
<pre>
A) Operational excellence
B) Performance efficiency
C) Cost optimization
D) Reliability
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Performance efficiency
  
  <strong>Explanation:</strong> Performance efficiency is the pillar of the AWS Well-Architected Framework that represents the requirements of designing a solution for the efficient use of compute resources for an enterprise workload and making informed decisions as the technology needs evolve. It focuses on using the right resources and services for the workload, monitoring performance, and continuously improving the efficiency of the solution.
  
  <strong>Why other options are incorrect:</strong>
  - A) Operational excellence represents the ability to run and monitor systems to deliver business value and to continually improve supporting processes and procedures
  - C) Cost optimization represents the ability to run systems to deliver business value at the lowest price point
  - D) Reliability represents the ability of a system to recover from infrastructure or service disruptions, dynamically acquire computing resources to meet demand, and mitigate disruptions
</details>

<h2>Question 124</h2>
(Topic 2) A company wants its workload to perform consistently and correctly. Which benefit of AWS Cloud computing does this goal represent?
<pre>
A) Security
B) Elasticity
C) Pay-as-you-go pricing
D) Reliability
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Reliability
  
  <strong>Explanation:</strong> Reliability is the benefit of AWS Cloud computing that ensures the workload performs consistently and correctly. According to the AWS Cloud Practitioner Essentials course, reliability means "the ability of a system to recover from infrastructure or service disruptions, dynamically acquire computing resources to meet demand, and mitigate disruptions such as misconfigurations or transient network issues." Elasticity, security, and pay-as-you-go pricing are also benefits of AWS Cloud computing, but they do not directly relate to the goal of consistent and correct performance.
</details>

<h2>Question 128</h2>
(Topic 2) Which service is an AWS in-memory data store service?
<pre>
A) Amazon Aurora
B) Amazon RDS
C) Amazon DynamoDB
D) Amazon ElastiCache
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon ElastiCache
  
  <strong>Explanation:</strong> Amazon ElastiCache is a service that offers fully managed in-memory data store and cache services that deliver sub-millisecond response times to applications. You can use Amazon ElastiCache to improve the performance of your applications by retrieving data from fast, managed, in-memory data stores, instead of relying entirely on slower disk-based databases.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Aurora is a relational database service that combines the performance and availability of high-end commercial databases with the simplicity and cost-effectiveness of open source databases
  - B) Amazon RDS is a service that makes it easy to set up, operate, and scale a relational database in the cloud
  - C) Amazon DynamoDB is a key-value and document database that delivers single-digit millisecond performance at any scale
</details>

<h2>Question 164</h2>
(Topic 1) A security engineer wants a single-tenant AWS solution to create, control, and manage their own cryptographic keys to meet regulatory compliance requirements for data security. Which AWS service should the engineer use?
<pre>
A) AWS Key Management Service (AWS KMS)
B) AWS Certificate Manager (ACM)
C) AWS CloudHSM
D) AWS Systems Manager
</pre>

<details>
  <summary>Answer:</summary>
  
  C) AWS CloudHSM
  
  <strong>Explanation:</strong> The correct answer is C because AWS CloudHSM is an AWS service that enables the security engineer to meet the requirements. AWS CloudHSM is a service that provides customers with dedicated hardware security modules (HSMs) to create, control, and manage their own cryptographic keys in the AWS Cloud. AWS CloudHSM allows customers to meet strict regulatory compliance requirements for data security, such as FIPS 140-2 Level 3, PCI-DSS, and HIPAA.
  
  <strong>Why other options are incorrect:</strong>
  - A) AWS Key Management Service (AWS KMS) is a service that provides customers with a fully managed, scalable, and integrated key management system to create and control encryption keys for AWS services and applications. AWS KMS does not provide customers with single-tenant or dedicated HSMs
  - B) AWS Certificate Manager (ACM) is a service that provides customers with a simple and secure way to provision, manage, and deploy public and private SSL/TLS certificates for use with AWS services and internal connected resources. ACM does not provide customers with HSMs or cryptographic keys
  - D) AWS Systems Manager is a service that provides customers with a unified user interface to view operational data from multiple AWS services and automate operational tasks across their AWS resources. AWS Systems Manager does not provide customers with HSMs or cryptographic keys
</details>

<h2>Question 168</h2>
(Topic 1) A company is designing an identity access management solution for an application. The company wants users to be able to use their social media, email, or online shopping accounts to access the application. Which AWS service provides this functionality?
<pre>
A) AWS IAM Identity Center (AWS Single Sign-On)
B) AWS Config
C) Amazon Cognito
D) AWS Identity and Access Management (IAM)
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon Cognito
  
  <strong>Explanation:</strong> The correct answer is C because Amazon Cognito provides identity federation and user authentication for web and mobile applications. Amazon Cognito allows users to sign in with their social media, email, or online shopping accounts.
  
  <strong>Why other options are incorrect:</strong>
  - A) AWS IAM Identity Center (AWS Single Sign-On) is a service that enables users to access multiple AWS accounts and applications with a single sign-on experience
  - B) AWS Config is a service that enables users to assess, audit, and evaluate the configurations of their AWS resources
  - D) AWS Identity and Access Management (IAM) is a service that enables users to manage access to AWS resources using users, groups, roles, and policies
</details>

<h2>Question 169</h2>
(Topic 1) Which AWS service provides a managed Microsoft Active Directory in the AWS Cloud?
<pre>
A) Amazon FSx for Windows File Server
B) Amazon Workspaces virtual Windows desktop
C) AWS Directory Service for Microsoft Active Directory
D) Amazon RDS for Microsoft SQL Server
</pre>

<details>
  <summary>Answer:</summary>
  
  C) AWS Directory Service for Microsoft Active Directory
  
  <strong>Explanation:</strong> AWS Directory Service for Microsoft Active Directory is the AWS service that provides a managed Microsoft Active Directory in the AWS Cloud. It enables the user to use their existing Active Directory users, groups, and policies to access AWS resources, such as Amazon EC2 instances, Amazon S3 buckets, and AWS Single Sign-On. It also integrates with other Microsoft applications and services, such as Microsoft SQL Server, Microsoft Office 365, and Microsoft SharePoint.
</details>

<h2>Question 170</h2>
(Topic 1) Which AWS service or feature is used to troubleshoot network connectivity issues between Amazon EC2 instances?
<pre>
A) AWS Certificate Manager (ACM)
B) Internet gateway
C) VPC Flow Logs
D) AWS CloudHSM
</pre>

<details>
  <summary>Answer:</summary>
  
  C) VPC Flow Logs
  
  <strong>Explanation:</strong> VPC Flow Logs is the AWS service or feature that is used to troubleshoot network connectivity issues between Amazon EC2 instances. VPC Flow Logs is a feature that enables users to capture information about the IP traffic going to and from network interfaces in their VPC. VPC Flow Logs can help users monitor and diagnose network-related issues, such as traffic not reaching an instance, or an instance not responding to requests. VPC Flow Logs can be published to Amazon CloudWatch Logs, Amazon S3, or Amazon Kinesis Data Firehose for analysis and storage.
</details>

<h2>Question 171</h2>
(Topic 1) A company needs to continuously monitor its environment to analyze network and account activity and identify potential security threats. Which AWS service should the company use to meet these requirements?
<pre>
A) AWS Artifact
B) Amazon Macie
C) AWS Identity and Access Management (IAM)
D) Amazon GuardDuty
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon GuardDuty
  
  <strong>Explanation:</strong> Amazon GuardDuty is a service that provides intelligent threat detection and continuous monitoring for the AWS environment. It analyzes network and account activity using machine learning and threat intelligence to identify potential security threats, such as unauthorized access, compromised credentials, malicious hosts, and reconnaissance activities. It also generates detailed and actionable findings that can be viewed on the AWS Management Console or sent to other AWS services, such as Amazon CloudWatch Events and AWS Lambda, for further analysis or remediation.
</details>

<h2>Question 174</h2>
(Topic 1) A company is using a third-party service to back up 10 TB of data to a tape library. The on-premises backup server is running out of space. The company wants to use AWS services for the backups without changing its existing backup workflows. Which AWS service should the company use to meet these requirements?
<pre>
A) Amazon Elastic Block Store (Amazon EBS)
B) AWS Storage Gateway
C) Amazon Elastic Container Service (Amazon ECS)
D) AWS Lambda
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Storage Gateway
  
  <strong>Explanation:</strong> The correct answer is B because AWS Storage Gateway is a service that should be used by the company to meet the requirements. AWS Storage Gateway is a service that connects on-premises software applications with cloud-based storage. AWS Storage Gateway supports three types of gateways: file gateway, volume gateway, and tape gateway. The tape gateway type enables users to back up and archive data to virtual tapes in AWS without changing their existing backup workflows. Users can use their existing backup applications and tape libraries to store data on virtual tapes in Amazon S3 or Amazon S3 Glacier.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Elastic Block Store (Amazon EBS) is a service that provides block-level storage volumes for Amazon EC2 instances
  - C) Amazon Elastic Container Service (Amazon ECS) is a service that enables users to run, scale, and secure containerized applications on AWS
  - D) AWS Lambda is a service that enables users to run code without provisioning or managing servers
</details>

<h2>Question 177</h2>
(Topic 1) Which AWS service can a company use to perform complex analytical queries?
<pre>
A) Amazon RDS
B) Amazon DynamoDB
C) Amazon Redshift
D) Amazon ElastiCache
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon Redshift
  
  <strong>Explanation:</strong> Amazon Redshift is a fully managed, petabyte-scale data warehouse service in the cloud. You can start with just a few hundred gigabytes of data and scale to a petabyte or more. This enables you to use your data to acquire new insights for your business and customers. Amazon Redshift is designed for complex analytical queries that often involve aggregations and joins across very large tables. Amazon Redshift supports standard SQL and integrates with many existing business intelligence tools.
</details>

<h2>Question 182</h2>
(Topic 1) A large company wants to track the combined AWS usage costs of all of its linked accounts. How can this be accomplished?
<pre>
A) Use AWS Trusted Advisor to generate customized summary reports
B) Use AWS Organizations to generate consolidated billing reports
C) Use AWS Budgets to set utilization targets and receive summary reports
D) Use the AWS Control Tower dashboard to get a summary report of all linked account costs
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Use AWS Organizations to generate consolidated billing reports
  
  <strong>Explanation:</strong> The company can use AWS Organizations to track the combined AWS usage costs of all of its linked accounts. AWS Organizations is a service that enables you to consolidate multiple AWS accounts into an organization that you can manage centrally. You can use AWS Organizations to create a consolidated billing report that shows the charges incurred by each account in your organization as well as the total charges across all accounts. You can also use AWS Organizations to apply policies and controls to your accounts to help you manage costs and security.
</details>

<h2>Question 183</h2>
(Topic 1) A company's information security manager is supervising a move to AWS and wants to ensure that AWS best practices are followed. The manager has concerns about the potential misuse of AWS account root user credentials. Which of the following is an AWS best practice for using the AWS account root user credentials?
<pre>
A) Allow only the manager to use the account root user credentials for normal activities
B) Use the account root user credentials only for Amazon EC2 instances from the AWS Free Tier
C) Use the account root user credentials only when they alone must be used to perform a required function
D) Use the account root user credentials only for the creation of private VPC subnets
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Use the account root user credentials only when they alone must be used to perform a required function
  
  <strong>Explanation:</strong> The AWS best practice for using the AWS account root user credentials is to use them only when they alone must be used to perform a required function. The AWS account root user credentials have full access to all the resources in the account, and therefore pose a security risk if compromised or misused. You should create individual IAM users with the minimum necessary permissions for everyday tasks, and use AWS Organizations to manage multiple accounts. You should also enable multi-factor authentication (MFA) and rotate the password for the root user regularly. Some of the functions that require the root user credentials are changing the account name, closing the account, changing the support plan, and restoring an IAM user's access.
</details>

<h2>Question 189</h2>
(Topic 1) Which tasks are customer responsibilities according to the AWS shared responsibility model? (Select TWO.)
<pre>
A) Determine application dependencies with operating systems
B) Provide user access with AWS Identity and Access Management (IAM)
C) Secure the data center in an Availability Zone
D) Patch the hypervisor
E) Provide network availability in Availability Zones
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Determine application dependencies with operating systems
  B) Provide user access with AWS Identity and Access Management (IAM)
  
  <strong>Explanation:</strong> The correct answer to the question is B because providing user access with AWS Identity and Access Management (IAM) is a customer responsibility according to the AWS shared responsibility model. The AWS shared responsibility model is a framework that defines the division of responsibilities between AWS and the customer for security and compliance. AWS is responsible for the security of the cloud, which includes the global infrastructure, such as the regions, availability zones, and edge locations; the hardware, software, networking, and facilities that run the AWS services; and the virtualization layer that separates the customer instances and storage. The customer is responsible for the security in the cloud, which includes the customer data, the guest operating systems, the applications, the identity and access management, the firewall configuration, and the encryption. IAM is an AWS service that enables customers to manage access and permissions to AWS resources and services. Customers are responsible for creating and managing IAM users, groups, roles, and policies, and ensuring that they follow the principle of least privilege.
</details>

<h2>Question 192</h2>
(Topic 1) Which of the following are advantages of the AWS Cloud? (Select TWO.)
<pre>
A) Trade variable expenses for capital expenses
B) High economies of scale
C) Launch globally in minutes
D) Focus on managing hardware infrastructure
E) Overprovision to ensure capacity
</pre>

<details>
  <summary>Answer:</summary>
  
  B) High economies of scale
  C) Launch globally in minutes
  
  <strong>Explanation:</strong> The correct answers are B and C because they are advantages of the AWS Cloud. High economies of scale means that AWS can achieve lower variable costs than customers can get on their own. Launch globally in minutes means that AWS has a global infrastructure that allows customers to deploy their applications and data across multiple regions and availability zones.
  
  <strong>Why other options are incorrect:</strong>
  - A) Trade variable expenses for capital expenses means that customers have to invest heavily in data centers and servers before they know how they will use them
  - D) Focus on managing hardware infrastructure means that customers have to spend time and money on maintaining and upgrading their physical resources
  - E) Overprovision to ensure capacity means that customers have to pay for more resources than they actually need to avoid performance issues
</details>

<h2>Question 194</h2>
(Topic 1) A company is building a serverless architecture that connects application data from multiple data sources. The company needs a solution that does not require additional code. Which AWS service meets these requirements?
<pre>
A) AWS Lambda
B) Amazon Simple Queue Service (Amazon SQS)
C) Amazon CloudWatch
D) Amazon EventBridge
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Amazon EventBridge
  
  <strong>Explanation:</strong> Amazon EventBridge is the service that meets the requirements of building a serverless architecture that connects application data from multiple data sources without requiring additional code. Amazon EventBridge is a serverless event bus service that allows you to easily connect your applications with data from AWS services, SaaS applications, and your own applications. You can use Amazon EventBridge to create rules that match events and route them to targets such as AWS Lambda functions, Amazon SNS topics, Amazon SQS queues, or other AWS services. Amazon EventBridge handles the event ingestion, delivery, security, authorization, and error handling for you.
</details>

<h2>Question 195</h2>
(Topic 1) Which AWS service or tool provides recommendations to help users get rightsized Amazon EC2 instances based on historical workload usage data?
<pre>
A) AWS Pricing Calculator
B) AWS Compute Optimizer
C) AWS App Runner
D) AWS Systems Manager
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Compute Optimizer
  
  <strong>Explanation:</strong> AWS Compute Optimizer is the AWS service or tool that provides recommendations to help users get rightsized Amazon EC2 instances based on historical workload usage data. AWS Compute Optimizer analyzes the configuration and performance characteristics of the EC2 instances and delivers recommendations for optimal instance types, sizes, and configurations. AWS Compute Optimizer helps users improve performance, reduce costs, and eliminate underutilized resources.
</details>

<h2>Question 199</h2>
(Topic 1) An Availability Zone consists of:
<pre>
A) one or more data centers in a single location
B) two or more data centers in multiple locations
C) one or more physical hosts in a single data center
D) two or more physical hosts in multiple data centers
</pre>

<details>
  <summary>Answer:</summary>
  
  A) one or more data centers in a single location
  
  <strong>Explanation:</strong> The correct answer is A because an Availability Zone consists of one or more data centers in a single location. An Availability Zone is an isolated location within an AWS Region that has independent power, cooling, and networking. Each Availability Zone has one or more data centers that host the physical servers and storage devices that run the AWS services.
  
  <strong>Why other options are incorrect:</strong>
  - B) Two or more data centers in multiple locations are not an Availability Zone, but rather multiple Availability Zones within an AWS Region
  - C) One or more physical hosts in a single data center are not an Availability Zone, but rather the components of a data center within an Availability Zone
  - D) Two or more physical hosts in multiple data centers are not an Availability Zone, but rather the components of multiple data centers within one or more Availability Zones
</details>

<h2>Question 204</h2>
(Topic 1) Which of the following acts as an instance-level firewall to control inbound and outbound access?
<pre>
A) Network access control list
B) Security groups
C) AWS Trusted Advisor
D) Virtual private gateways
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Security groups
  
  <strong>Explanation:</strong> The correct answer is B because security groups are AWS features that act as instance-level firewalls to control inbound and outbound access. Security groups are virtual firewalls that can be attached to one or more Amazon EC2 instances. Users can configure rules for security groups to allow or deny traffic based on protocols, ports, and source or destination IP addresses.
</details>

<h2>Question 209</h2>
(Topic 1) A retail company is migrating its IT infrastructure applications from on premises to the AWS Cloud. Which costs will the company eliminate with this migration? (Select TWO.)
<pre>
A) Cost of data center operations
B) Cost of application licensing
C) Cost of marketing campaigns
D) Cost of physical server hardware
E) Cost of network management
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Cost of data center operations
  D) Cost of physical server hardware
  
  <strong>Explanation:</strong> The costs that the company will eliminate with this migration are the cost of data center operations and the cost of physical server hardware. The cost of data center operations includes expenses such as power, cooling, security, and facility maintenance. The cost of physical server hardware is the expense that the company has to incur to purchase, maintain, and upgrade the servers and related equipment. By migrating to the AWS Cloud, the company can avoid these costs by using the AWS services and resources that are already managed by AWS.
</details>

<h2>Question 210</h2>
(Topic 1) A developer needs to build an application for a retail company. The application must provide real-time product recommendations that are based on machine learning. Which AWS service should the developer use to meet this requirement?
<pre>
A) AWS Health Dashboard
B) Amazon Personalize
C) Amazon Forecast
D) Amazon Transcribe
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Amazon Personalize
  
  <strong>Explanation:</strong> Amazon Personalize is a fully managed machine learning service that customers can use to generate personalized recommendations for their users. It can also generate user segments based on the users' affinity for certain items or item metadata. Amazon Personalize uses the customers' data to train and deploy custom recommendation models that can be integrated into their applications. Therefore, the correct answer is B.
</details>

<h2>Question 216</h2>
(Topic 3) Which AWS service provides protection against DDoS attacks for applications that run in the AWS Cloud?
<pre>
A) Amazon VPC
B) AWS Shield
C) AWS Audit Manager
D) AWS Config
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Shield
  
  <strong>Explanation:</strong> AWS Shield is an AWS service that provides protection against distributed denial of service (DDoS) attacks for applications that run in the AWS Cloud. DDoS attacks are attempts to make an online service unavailable by overwhelming it with traffic from multiple sources. AWS Shield provides two tiers of protection: AWS Shield Standard and AWS Shield Advanced. AWS Shield Standard is automatically enabled for all AWS customers at no additional charge. It provides protection against common and frequently occurring network and transport layer DDoS attacks. AWS Shield Advanced is an optional paid service that provides additional protection against larger and more sophisticated DDoS attacks. AWS Shield Advanced also provides access to 24/7 DDoS response team, cost protection, and enhanced detection and mitigation capabilities.
</details>

<h2>Question 218</h2>
(Topic 3) Which option is a perspective that includes foundational capabilities of the AWS Cloud Adoption Framework (AWS CAF)?
<pre>
A) Sustainability
B) Security
C) Performance efficiency
D) Reliability
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Security
  
  <strong>Explanation:</strong> The AWS Cloud Adoption Framework (AWS CAF) helps organizations understand how cloud adoption transforms the way they work, and it provides structure to identify and address gaps in skills and processes. The AWS CAF organizes guidance into six areas of focus, called perspectives. Each perspective reflects a different stakeholder viewpoint with its own distinct responsibilities, skills, and attributes. The Security Perspective helps you structure the selection and implementation of security controls that meet your organization's needs.
</details>

<h2>Question 219</h2>
(Topic 3) A company is planning to host its workloads on AWS. Which AWS service requires the company to update and patch the guest operating system?
<pre>
A) Amazon DynamoDB
B) Amazon S3
C) Amazon EC2
D) Amazon Aurora
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon EC2
  
  <strong>Explanation:</strong> Amazon EC2 is an AWS service that provides scalable, secure, and resizable compute capacity in the cloud. Amazon EC2 allows customers to launch and manage virtual servers, called instances, that run a variety of operating systems and applications. Customers have full control over the configuration and management of their instances, including the guest operating system. Therefore, customers are responsible for updating and patching the guest operating system on their EC2 instances, as well as any other software or utilities installed on the instances. AWS provides tools and services, such as AWS Systems Manager and AWS OpsWorks, to help customers automate and simplify the patching process.
</details>

<h2>Question 220</h2>
(Topic 3) A company needs to apply security rules to specific Amazon EC2 instances. Which AWS service or feature provides this functionality?
<pre>
A) AWS Shield
B) Network ACLs
C) Security groups
D) AWS Firewall Manager
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Security groups
  
  <strong>Explanation:</strong> Security groups act as a firewall for associated Amazon EC2 instances, controlling both inbound and outbound traffic at the instance level. You can use security groups to set rules that allow or deny traffic to or from your instances. You can modify the rules for a security group at any time; the new rules are automatically applied to all instances that are associated with the security group.
</details>

<h2>Question 222</h2>
(Topic 3) Which AWS service converts text to lifelike voices?
<pre>
A) Amazon Transcribe
B) Amazon Rekognition
C) Amazon Polly
D) Amazon Textract
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon Polly
  
  <strong>Explanation:</strong> Amazon Polly is a service that turns text into lifelike speech, allowing you to create applications that talk, and build entirely new categories of speech-enabled products. Polly's Text-to-Speech (TTS) service uses advanced deep learning technologies to synthesize natural sounding human speech. Amazon Polly supports dozens of languages and a wide range of natural-sounding voices. You can customize and control the speech output by using lexicons and SSML tags. You can also store and redistribute the speech output in standard audio formats like MP3 and OGG.
</details>

<h2>Question 227</h2>
(Topic 3) Which Amazon S3 storage class is the MOST cost-effective for long-term storage?
<pre>
A) S3 Glacier Deep Archive
B) S3 Standard
C) S3 Standard-Infrequent Access (S3 Standard-IA)
D) S3 One Zone-Infrequent Access (S3 One Zone-IA)
</pre>

<details>
  <summary>Answer:</summary>
  
  A) S3 Glacier Deep Archive
  
  <strong>Explanation:</strong> Amazon S3 Glacier Deep Archive is the lowest-cost storage class in the cloud. It is designed for long-term data archiving that is rarely accessed. It offers a retrieval time of 12 hours and a durability of 99.999999999% (11 9's). It is ideal for data that must be retained for 7 years or longer to meet regulatory compliance requirements.
</details>

<h2>Question 231</h2>
(Topic 3) An ecommerce company wants to provide relevant product recommendations to its customers. The recommendations will include products that are frequently purchased with other products that the customer already purchased. The recommendations also will include products of a specific color and products from the customer's favorite brand. Which AWS service or feature should the company use to meet these requirements with the LEAST development effort?
<pre>
A) Amazon Comprehend
B) Amazon Forecast
C) Amazon Personalize
D) Amazon SageMaker Studio
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon Personalize
  
  <strong>Explanation:</strong> Amazon Personalize is a service that provides real-time personalized recommendations based on the user's behavior, preferences, and context. It can also incorporate metadata such as product color and brand to generate more relevant recommendations. Amazon Personalize can analyze purchase patterns, user preferences, and product metadata to provide personalized recommendations with minimal development effort.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Comprehend is a natural language processing (NLP) service that can analyze text for entities, sentiments, topics, and more
  - B) Amazon Forecast is a service that provides accurate time-series forecasting based on machine learning
  - D) Amazon SageMaker Studio is a web-based integrated development environment (IDE) for machine learning
</details>

<h2>Question 232</h2>
(Topic 1) Amazon Elastic File System (Amazon EFS) and Amazon FSx offer which type of storage?
<pre>
A) File storage
B) Object storage
C) Block storage
D) Instance store
</pre>

<details>
  <summary>Answer:</summary>
  
  A) File storage
  
  <strong>Explanation:</strong> Amazon Elastic File System (Amazon EFS) and Amazon FSx are AWS services that offer file storage. File storage is a type of storage that organizes data into files and folders that can be accessed and shared over a network. File storage is suitable for applications that require shared access to data, such as content management, media processing, and web serving. Amazon EFS provides a simple, scalable, and fully managed elastic file system that can be used with AWS Cloud services and on-premises resources. Amazon FSx provides fully managed third-party file systems, such as Windows File Server and Lustre, with native compatibility and high performance.
</details>

<h2>Question 240</h2>
(Topic 3) Which AWS service is a continuous delivery and deployment solution?
<pre>
A) AWS AppSync
B) AWS CodePipeline
C) AWS Cloud9
D) AWS CodeCommit
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS CodePipeline
  
  <strong>Explanation:</strong> AWS CodePipeline is a continuous delivery and deployment service that automates the release process of software applications across different stages, such as source code, build, test, and deploy. AWS AppSync, AWS Cloud9, and AWS CodeCommit are other AWS services related to application development, but they do not provide continuous delivery and deployment solutions.
</details>

<h2>Question 245</h2>
(Topic 3) Which option is an AWS Cloud Adoption Framework (AWS CAF) foundational capability for the operations perspective?
<pre>
A) Performance and capacity management
B) Application portfolio management
C) Identity and access management
D) Product management
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Identity and access management
  
  <strong>Explanation:</strong> Identity and access management is one of the foundational capabilities for the operations perspective of the AWS Cloud Adoption Framework (AWS CAF). It involves managing the identities, roles, permissions, and credentials of users and systems that interact with AWS resources. Performance and capacity management is a capability for the platform perspective. Application portfolio management is a capability for the business perspective. Product management is a capability for the governance perspective.
</details>

<h2>Question 248</h2>
(Topic 3) Which of the following are pillars of the AWS Well-Architected Framework? (Select TWO.)
<pre>
A) High availability
B) Performance efficiency
C) Cost optimization
D) Going global in minutes
E) Continuous development
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Performance efficiency
  C) Cost optimization
  
  <strong>Explanation:</strong> The AWS Well-Architected Framework is a set of six pillars and lenses that help cloud architects design and run workloads in the cloud. The six pillars are: operational excellence, security, reliability, performance efficiency, cost optimization, and sustainability. Each pillar has a set of design principles and best practices that guide the architectural decisions. High availability is not a separate pillar, but a quality that can be achieved by applying the principles of the reliability pillar. Going global in minutes and continuous development are not pillars of the framework, but possible benefits of using AWS services and following the framework's recommendations.
</details>

<h2>Question 250</h2>
(Topic 3) Which actions are best practices for an AWS account root user? (Select TWO.)
<pre>
A) Share root user credentials with team members
B) Create multiple root users for the account, separated by environment
C) Enable multi-factor authentication (MFA) on the root user
D) Create an IAM user with administrator privileges for daily administrative tasks, instead of using the root user
E) Use programmatic access instead of the root user and password
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Enable multi-factor authentication (MFA) on the root user
  D) Create an IAM user with administrator privileges for daily administrative tasks, instead of using the root user
  
  <strong>Explanation:</strong> The AWS account root user is the identity that has complete access to all AWS services and resources in the account. It is accessed by signing in with the email address and password that were used to create the account. The root user should be protected and used only for a few account and service management tasks that require it. Therefore, the following actions are best practices for an AWS account root user:
  
  - Enable multi-factor authentication (MFA) on the root user. MFA is a security feature that requires users to provide two or more pieces of information to authenticate themselves, such as a password and a code from a device. MFA adds an extra layer of protection for the root user credentials, which can access sensitive information and perform critical operations in the account.
  - Create an IAM user with administrator privileges for daily administrative tasks, instead of using the root user. IAM is a service that helps customers manage access to AWS resources for users and groups. Customers can create IAM users and assign them permissions to perform specific tasks on specific resources. By creating an IAM user with administrator privileges, customers can avoid using the root user for everyday tasks and reduce the risk of accidental or malicious changes to the account.
</details>

<h2>Question 253</h2>
(Topic 3) A company wants an automated process to continuously scan its Amazon EC2 instances for software vulnerabilities. Which AWS service will meet these requirements?
<pre>
A) Amazon GuardDuty
B) Amazon Inspector
C) Amazon Detective
D) Amazon Cognito
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Amazon Inspector
  
  <strong>Explanation:</strong> Amazon Inspector is the AWS service that can be used to perform vulnerability scans on AWS EC2 instances for software vulnerabilities automatically in a periodic fashion. Amazon Inspector automatically discovers EC2 instances and scans them for software vulnerabilities and unintended network exposure. Amazon Inspector uses AWS Systems Manager (SSM) and the SSM Agent to collect information about the software application inventory of the EC2 instances. This data is then scanned by Amazon Inspector for software vulnerabilities. Amazon Inspector also integrates with other AWS services, such as Amazon EventBridge and AWS Security Hub, to automate discovery, expedite vulnerability routing, and shorten mean time to remediate (MTTR) vulnerabilities.
</details>

<h2>Question 255</h2>
(Topic 3) A company is moving an on-premises data center to the AWS Cloud. The company must migrate 50 petabytes of file storage data to AWS with the least possible operational overhead. Which AWS service or resource should the company use to meet these requirements?
<pre>
A) AWS Snowmobile
B) AWS Snowball Edge
C) AWS Data Exchange
D) AWS Database Migration Service (AWS DMS)
</pre>

<details>
  <summary>Answer:</summary>
  
  A) AWS Snowmobile
  
  <strong>Explanation:</strong> The AWS service that the company should use to meet these requirements is AWS Snowmobile. AWS Snowmobile is a service that allows you to migrate large amounts of data to AWS using a 45-foot long ruggedized shipping container that can store up to 100 petabytes of data. AWS Snowmobile is designed for situations where you need to move massive amounts of data to the cloud in a fast, secure, and cost-effective way. AWS Snowmobile has the least possible operational overhead because it eliminates the need to buy, configure, or manage hundreds or thousands of storage devices.
  
  <strong>Why other options are incorrect:</strong>
  - B) AWS Snowball Edge is a service that allows you to migrate data to AWS using a physical device that can store up to 80 terabytes of data and has compute and storage capabilities to run applications on the device
  - C) AWS Data Exchange is a service that allows you to find, subscribe to, and use third-party data in the cloud. It is not a data migration service
  - D) AWS Database Migration Service (AWS DMS) is a service that helps migrate databases to AWS. It does not migrate file storage data
</details>

<h2>Question 257</h2>
(Topic 3) Which mechanism allows developers to access AWS services from application code?
<pre>
A) AWS Software Development Kit
B) AWS Management Console
C) AWS CodePipeline
D) AWS Config
</pre>

<details>
  <summary>Answer:</summary>
  
  A) AWS Software Development Kit
  
  <strong>Explanation:</strong> AWS Software Development Kit (SDK) is a set of platform-specific building tools for developers. It allows developers to access AWS services from application code using familiar programming languages. It provides pre-built components and libraries that can be incorporated into applications, as well as tools to debug, monitor, and optimize performance.
</details>

<h2>Question 260</h2>
(Topic 3) According to the AWS shared responsibility model, who is responsible for the virtualization layer down to the physical security of the facilities in which AWS services operate?
<pre>
A) It is the sole responsibility of the customer
B) It is the sole responsibility of AWS
C) It is a shared responsibility between AWS and the customer
D) The customer's AWS Support plan tier determines who manages the configuration
</pre>

<details>
  <summary>Answer:</summary>
  
  B) It is the sole responsibility of AWS
  
  <strong>Explanation:</strong> According to the AWS shared responsibility model, AWS is responsible for the security of the cloud, which includes the virtualization layer down to the physical security of the facilities in which AWS services operate. The customer is responsible for the security in the cloud, which includes the configuration and management of the AWS resources and applications that they use.
</details>

<h2>Question 263</h2>
(Topic 3) A company wants to create a globally accessible ecommerce platform for its customers. The company wants to use a highly available and scalable DNS web service to connect users to the platform. Which AWS service will meet these requirements?
<pre>
A) Amazon EC2
B) Amazon VPC
C) Amazon Route 53
D) Amazon RDS
</pre>

<details>
  <summary>Answer:</summary>
  
  C) Amazon Route 53
  
  <strong>Explanation:</strong> Amazon Route 53 is a highly available and scalable Domain Name System (DNS) web service that can route internet traffic to the company's ecommerce platform. Route 53 can also register domain names, check the health of resources, and provide global DNS features. Route 53 can connect users to the platform by translating human-readable names like www.example.com into the numeric IP addresses that computers use to communicate with each other.
</details>

<h2>Question 272</h2>
(Topic 3) A company wants a customized assessment of its current on-premises environment. The company wants to understand its projected running costs in the AWS Cloud. Which AWS service or tool will meet these requirements?
<pre>
A) AWS Trusted Advisor
B) Amazon Inspector
C) AWS Control Tower
D) Migration Evaluator
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Migration Evaluator
  
  <strong>Explanation:</strong> Migration Evaluator is an AWS service that provides a customized assessment of your current on-premises environment and helps you build a data-driven business case for migration to AWS. Migration Evaluator collects and analyzes data from your on-premises servers, such as CPU, memory, disk, network, and utilization metrics, and compares them with the most cost-effective AWS alternatives. Migration Evaluator also helps you understand your existing software licenses and running costs, and provides recommendations for Bring Your Own License (BYOL) and License Included (LI) options in AWS. Migration Evaluator generates a detailed report that shows your projected running costs in the AWS Cloud, along with potential savings and benefits.
</details>

<h2>Question 275</h2>
(Topic 3) Which of the following is a software development framework that a company can use to define cloud resources as code and provision the resources through AWS CloudFormation?
<pre>
A) AWS CLI
B) AWS Developer Center
C) AWS Cloud Development Kit (AWS CDK)
D) AWS CodeStar
</pre>

<details>
  <summary>Answer:</summary>
  
  C) AWS Cloud Development Kit (AWS CDK)
  
  <strong>Explanation:</strong> AWS Cloud Development Kit (AWS CDK) is a software development framework that allows you to define cloud resources as code using familiar programming languages, such as TypeScript, Python, Java, .NET, and Go (in Developer Preview). You can use AWS CDK to model your application resources using high-level constructs that provide sensible defaults and best practices, or use low-level constructs that provide full access to the underlying AWS CloudFormation resources. AWS CDK synthesizes your code into AWS CloudFormation templates that you can deploy using the AWS CDK CLI or the AWS Management Console. AWS CDK also integrates with other AWS services, such as AWS CodeCommit, AWS CodeBuild, AWS CodePipeline, AWS Lambda, Amazon EC2, Amazon S3, and more, to help you automate your development and deployment processes.
</details>

<h2>Question 276</h2>
(Topic 3) Which task must a user perform by using the AWS account root user credentials?
<pre>
A) Make changes to AWS production resources
B) Change AWS Support plans
C) Access AWS Cost and Usage Reports
D) Grant auditors' access to an AWS account for a compliance audit
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Change AWS Support plans
  
  <strong>Explanation:</strong> The AWS account root user is the email address that you used to sign up for AWS. The root user has complete access to all AWS services and resources in the account. You should use the root user only to perform a few account and service management tasks. One of these tasks is changing AWS Support plans, which requires root user credentials. For other tasks, you should create an IAM user or role with the appropriate permissions and use that instead of the root user.
</details>

<h2>Question 280</h2>
(Topic 3) Which AWS service is always provided at no charge?
<pre>
A) Amazon S3
B) AWS Identity and Access Management (IAM)
C) Elastic Load Balancers
D) AWS WAF
</pre>

<details>
  <summary>Answer:</summary>
  
  B) AWS Identity and Access Management (IAM)
  
  <strong>Explanation:</strong> AWS Identity and Access Management (IAM) is a web service that helps you securely control access to AWS resources. You can use IAM to create and manage AWS users and groups, and use permissions to allow and deny their access to AWS resources. IAM is always provided at no charge.
</details>

<h2>Question 281</h2>
(Topic 3) A company wants a time-series database service that makes it easier to store and analyze trillions of events each day. Which AWS service will meet this requirement?
<pre>
A) Amazon Neptune
B) Amazon Timestream
C) Amazon Forecast
D) Amazon DocumentDB (with MongoDB compatibility)
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Amazon Timestream
  
  <strong>Explanation:</strong> Amazon Timestream is a fast, scalable, and serverless time-series database service for IoT and other operational applications that makes it easy to store and analyze trillions of events per day up to 1,000 times faster and at as little as 1/10th the cost of relational databases. Amazon Timestream saves you time and cost in managing the lifecycle of time series data, and its purpose-built query engine lets you access and analyze recent and historical data together with a single query. Amazon Timestream has built-in time series analytics functions, helping you identify trends and patterns in near real time.
  
  <strong>Why other options are incorrect:</strong>
  - A) Amazon Neptune is a graph database service that supports highly connected data sets
  - C) Amazon Forecast is a machine learning service that generates accurate forecasts based on historical data
  - D) Amazon DocumentDB (with MongoDB compatibility) is a document database service that supports MongoDB workloads
</details>

<h2>Question 283</h2>
(Topic 3) A company's IT team is managing MySQL database server clusters. The IT team has to patch the database and take backup snapshots of the data in the clusters. The company wants to move this workload to AWS so that these tasks will be completed automatically. What should the company do to meet these requirements?
<pre>
A) Deploy MySQL database server clusters on Amazon EC2 instances
B) Use Amazon RDS with a MySQL database
C) Use an AWS CloudFormation template to deploy MySQL database servers on Amazon EC2 instances
D) Migrate all the MySQL database data to Amazon S3
</pre>

<details>
  <summary>Answer:</summary>
  
  B) Use Amazon RDS with a MySQL database
  
  <strong>Explanation:</strong> Amazon RDS is a service that makes it easy to set up, operate, and scale a relational database in the cloud. Amazon RDS supports MySQL as one of the database engines. By using Amazon RDS with a MySQL database, the company can offload the tasks of patching the database and taking backup snapshots to AWS. Amazon RDS automatically patches the database software and operating system of the database instances. Amazon RDS also automatically backs up the database and retains the backups for a user-defined retention period. The company can also restore the database to any point in time within the retention period.
  
  <strong>Why other options are incorrect:</strong>
  - A) Deploying MySQL database server clusters on Amazon EC2 instances would not automate the tasks of patching the database and taking backup snapshots
  - C) Using an AWS CloudFormation template to deploy MySQL database servers on Amazon EC2 instances would not automate the tasks of patching the database and taking backup snapshots
  - D) Migrating all the MySQL database data to Amazon S3 would not provide a relational database service with automated patching and backup capabilities
</details>

<h2>Question 287</h2>
(Topic 3) At what support level do users receive access to a support concierge?
<pre>
A) Basic Support
B) Developer Support
C) Business Support
D) Enterprise Support
</pre>

<details>
  <summary>Answer:</summary>
  
  D) Enterprise Support
  
  <strong>Explanation:</strong> Users receive access to a support concierge at the Enterprise Support level. A support concierge is a team of AWS billing and account experts that specialize in working with enterprise accounts. They can help users with billing and account inquiries, cost optimization, FinOps support, cost analysis, and prioritized answers to billing questions. The support concierge is included as part of the Enterprise Support plan, which also provides access to a Technical Account Manager (TAM), Infrastructure Event Management, AWS Trusted Advisor, and 24/7 technical support.
</details>

<h2>Question 291</h2>
(Topic 3) A company wants to migrate to AWS and use the same security software it uses on premises. The security software vendor offers its security software as a service on AWS. Where can the company purchase the security solution?
<pre>
A) AWS Partner Solutions Finder
B) AWS Support Center
C) AWS Management Console
D) AWS Marketplace
</pre>

<details>
  <summary>Answer:</summary>
  
  D) AWS Marketplace
  
  <strong>Explanation:</strong> AWS Marketplace is an online store that helps customers find, buy, and immediately start using the software and services that run on AWS. Customers can choose from a wide range of software products in popular categories such as security, networking, storage, machine learning, business intelligence, database, and DevOps. Customers can also use AWS Marketplace to purchase software as a service (SaaS) solutions that are integrated with AWS. Customers can benefit from simplified procurement, billing, and deployment processes, as well as flexible pricing options and free trials. Customers can also leverage AWS Marketplace to discover and subscribe to solutions offered by AWS Partners, such as the security software vendor mentioned in the question.
</details>

<h2>Question 294</h2>
(Topic 3) A company wants to use the AWS Cloud to deploy an application globally. Which architecture deployment model should the company use to meet this requirement?
<pre>
A) Multi-Region
B) Single-Region
C) Multi-AZ
D) Single-AZ
</pre>

<details>
  <summary>Answer:</summary>
  
  A) Multi-Region
  
  <strong>Explanation:</strong> The architecture deployment model that the company should use to meet this requirement is Multi-Region. A multi-region deployment model is a cloud computing architecture that distributes an application and its data across multiple geographic regions. A multi-region deployment model enables a company to achieve global reach, high availability, disaster recovery, and performance optimization. By deploying an application in multiple regions, a company can serve customers from the nearest region, reduce latency, increase redundancy, and comply with data sovereignty regulations.
  
  <strong>Why other options are incorrect:</strong>
  - B) A single-region deployment model is simpler and cheaper than a multi-region deployment model, but it has limited scalability, availability, and performance
  - C) A multi-AZ deployment model distributes an application across multiple Availability Zones within a single region, not globally
  - D) A single-AZ deployment model runs an application within a single Availability Zone and has no redundancy or fault tolerance
</details>
