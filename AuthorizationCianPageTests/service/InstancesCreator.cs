using AuthorizationCianPageTests.model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.Json;

namespace AuthorizationCianPageTests.service
{
    class InstancesCreator
    {
        // private static readonly string _jsonFile = System.Environment.GetEnvironmentVariable("environment") + ".json";
        private static readonly string _jsonFile = "C:\\C#\\task1\\AuthorizationCianPageTests\\AuthorizationCianPageTests\\dev.json";

        public static Instances GetParametersFromJson()
        {
            return JsonSerializer.Deserialize<Instances>(File.ReadAllText(_jsonFile));
        }

    }
}
