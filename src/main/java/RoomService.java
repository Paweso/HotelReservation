public class RoomService {
    RoomRepository repository = new RoomRepository();


    public Room createNewRoom(int number, int[] bedTypesOptions) {

        BedType[] bedTypes = new BedType[bedTypesOptions.length];

        for (int i = 0; i < bedTypesOptions.length; i++) {

            BedType bedType = switch (bedTypesOptions[i]) {
                case 1 -> BedType.SINGLE;
                case 2 -> BedType.DOUBLE;
                case 3 -> BedType.KING_SIZE;
                default -> throw new WrongOptionException("Wrong option when selecting bed type!");
            };
            bedTypes[i] = bedType;
        }
        return repository.createNewRoom(number, bedTypes);
    }
}
