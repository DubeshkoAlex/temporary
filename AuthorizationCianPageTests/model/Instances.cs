using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace AuthorizationCianPageTests.model
{
    public class Instances
    {
        private int numberOfInstances;
        private string instancesPurpose;
        private string operatingSystem;
        private string vmClass;
        private string series;
        private string instanceType;
        private int gpuNumbers;
        private string gpuType;
        private string localSSD;
        private string dataCenterLocation;
        private int commitedUsage;
        public Instances() { }

        public Instances(int numberOfInstances, string instancesPurpose, 
                         string operatingSystem, string vmClass, 
                         string series, string instanceType, 
                         int gpuNumbers, string gpuType, string localSSD, 
                         string dataCenterLocation, int commitedUsage)
        {
            this.numberOfInstances = numberOfInstances;
            this.instancesPurpose = instancesPurpose;
            this.operatingSystem = operatingSystem;
            this.vmClass = vmClass;
            this.series = series;
            this.instanceType = instanceType;
            this.gpuNumbers = gpuNumbers;
            this.gpuType = gpuType;
            this.localSSD = localSSD;
            this.dataCenterLocation = dataCenterLocation;
            this.commitedUsage = commitedUsage;
        }
        public int NumberOfInstances { get => numberOfInstances; set => numberOfInstances = value; }
        public string InstancesPurpose { get => instancesPurpose; set => instancesPurpose = value; }
        public string OperatingSystem { get => operatingSystem; set => operatingSystem = value; }
        public string VmClass { get => vmClass; set => vmClass = value; }
        public string Series { get => series; set => series = value; }
        public string InstanceType { get => instanceType; set => instanceType = value; }
        public int GpuNumbers { get => gpuNumbers; set => gpuNumbers = value; }
        public string GpuType { get => gpuType; set => gpuType = value; }
        public string LocalSSD { get => localSSD; set => localSSD = value; }
        public string DataCenterLocation { get => dataCenterLocation; set => dataCenterLocation = value; }
        public int CommitedUsage { get => commitedUsage; set => commitedUsage = value; }

        public bool EqualsBySmokeTestParam(object obj)
        {
            return obj is Instances instances &&
                    Object.Equals(vmClass.ToLower(), instances.vmClass.ToLower()) &&
                    Object.Equals(instanceType.ToLower(), instances.instanceType.ToLower()) &&
                    Object.Equals(localSSD.ToLower(), instances.localSSD.ToLower()) &&
                    Object.Equals(dataCenterLocation.ToLower(), instances.dataCenterLocation.ToLower()) &&
                    commitedUsage == instances.commitedUsage;
        }

        public override bool Equals(object obj)
        {
            return obj is Instances instances &&
                   numberOfInstances == instances.numberOfInstances &&
                   instancesPurpose == instances.instancesPurpose &&
                   operatingSystem == instances.operatingSystem &&
                   vmClass == instances.vmClass &&
                   series == instances.series &&
                   instanceType == instances.instanceType &&
                   gpuNumbers == instances.gpuNumbers &&
                   gpuType == instances.gpuType &&
                   localSSD == instances.localSSD &&
                   dataCenterLocation == instances.dataCenterLocation &&
                   commitedUsage == instances.commitedUsage;
        }

        public override int GetHashCode()
        {
            HashCode hash = new HashCode();
            hash.Add(numberOfInstances);
            hash.Add(instancesPurpose);
            hash.Add(operatingSystem);
            hash.Add(vmClass);
            hash.Add(series);
            hash.Add(instanceType);
            hash.Add(gpuNumbers);
            hash.Add(gpuType);
            hash.Add(localSSD);
            hash.Add(dataCenterLocation);
            hash.Add(commitedUsage);
            return hash.ToHashCode();
        }

        public override string ToString()
        {
            return "Instances{" +
                    "numberOfInstances=" + numberOfInstances +
                    ", instancesPurpose='" + instancesPurpose + '\'' +
                    ", operatingSystem='" + operatingSystem + '\'' +
                    ", vmClass='" + vmClass + '\'' +
                    ", series='" + series + '\'' +
                    ", instanceType='" + instanceType + '\'' +
                    ", gpuNumbers=" + gpuNumbers +
                    ", gpuType='" + gpuType + '\'' +
                    ", localSSD='" + localSSD + '\'' +
                    ", dataCenterLocation='" + dataCenterLocation + '\'' +
                    ", commitedUsage='" + commitedUsage + '\'' +
                    '}';
        }
    }
}
