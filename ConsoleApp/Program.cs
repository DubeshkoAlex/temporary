using AuthorizationCianPageTests.model;
using System.Text.Json;
using System.IO;
using System.Configuration;

Instances instance = new Instances();
instance.NumberOfInstances = 4;
instance.InstancesPurpose = null;
instance.OperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
instance.VmClass = "Regular";
instance.Series = "N1";
instance.InstanceType = "n1-standard-8";
instance.GpuNumbers = 1;
instance.GpuType = "NVIDIA Tesla V100";
instance.LocalSSD = "2x375";
instance.DataCenterLocation = "Frankfurt";
instance.CommitedUsage = 1;

/*string objectSerialized = JsonSerializer.Serialize(instance);
File.WriteAllText(Environment.CurrentDirectory + "\\dev.json", objectSerialized);
Console.WriteLine(AppDomain.CurrentDomain.BaseDirectory);
Instances? instance1 = JsonSerializer.Deserialize<Instances?>(objectSerialized);
Console.WriteLine(instance1.LocalSSD + " " + instance1.GpuType);*/

Console.WriteLine(File.ReadAllText("dev.json"));

/*string fileName = System.Environment.GetEnvironmentVariable("environment") + ".json";

string fullPath = "C:\\C#\\task1\\AuthorizationCianPageTests\\AuthorizationCianPageTests\\resources\\" + fileName;

string jsonObject = File.ReadAllText(fullPath);

Instance? instances1 = JsonSerializer.Deserialize<Instance>(jsonObject);

Console.WriteLine(instances1.LocalSSD);*/

/*var environmentalConstants = new EnvironmentalConstants();
string objectSerialized = JsonSerializer.Serialize(environmentalConstants);
File.WriteAllText("C:\\C#\\task1\\AuthorizationCianPageTests\\AuthorizationCianPageTests\\resources\\test.json", objectSerialized);

EnvironmentalConstants? environmentalConstants1 = JsonSerializer.Deserialize<EnvironmentalConstants?>(objectSerialized);
Console.WriteLine(environmentalConstants1.Name + " " + environmentalConstants1.Surname);



public class EnvironmentalConstants
{
    public string Name { get; set; } = "Vlad";
    public string Surname { get; set; } = "Boger";
}*/



