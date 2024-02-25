package com.project;

public class FlightDetails {
        private String FlightNo;
        private String Origin;
        private String Destination;
        private String FlightTime;
        private String TypeofFlight;
        private int NoofSeats;
        private double Price;

        public FlightDetails() {
        }
        public String getFlightNo() {
            return FlightNo;
        }
        public void setFlightNo(String FlightNo) {
            this.FlightNo = FlightNo;
        }

        public String getOrigin() {
            return Origin;
        }
        public void setOrigin(String Origin) {
            this.Origin = Origin;
        }

        public String getDestination() {
            return Destination;
        }
        public void setDestination(String Destination) {
            this.Destination = Destination;
        }

        public String getFlightTime() {
            return FlightTime;
        }
        public void setFlightTime(String FlightTime) {
            this.FlightTime = FlightTime;
        }

        public String getTypeofFlight() {
            return TypeofFlight;
        }
        public void setTypeofFlight(String TypeofFlight) {
            this.TypeofFlight = TypeofFlight;
        }

        public int getNoofSeats() {
            return NoofSeats;
        }
        public void setNoofSeats(int NoofSeats) {
            this.NoofSeats = NoofSeats;
        }

        public double getPrice() {
            return Price;
        }
        public void setPrice(double Price) {
            this.Price = Price;
        }

    @Override
    public String toString() {
        return "FlightDetails{" +
                "FlightNo='" + FlightNo + '\'' +
                ", Origin='" + Origin + '\'' +
                ", Destination='" + Destination + '\'' +
                ", FlightTime='" + FlightTime + '\'' +
                ", TypeofFlight='" + TypeofFlight + '\'' +
                ", NoofSeats=" + NoofSeats +
                ", Price=" + Price +
                '}';
    }
}
