namespace java com.devguru.thrift.model

struct SquareRequest {
    1: i32 number;
}

struct SquareResponse {
    1: i32 number;
    2: i32 result;
}

service SquareService {
    SquareResponse findSquare(1: i32 number);
}