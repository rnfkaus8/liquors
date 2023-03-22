export class Review {
  private readonly _id: number;
  private readonly _liquorId: number;

  // TODO 사진 업로드 기능 추가(혹은 핸드폰 카메라에 접근하여 바로 업로드가 가능하게 구현할 예정)
  // private readonly image: Image;

  constructor(id: number, liquorId: number) {
  	this._id = id;
  	this._liquorId = liquorId;
  }

  get id(): number {
  	return this._id;
  }

  get liquorId(): number {
  	return this._liquorId;
  }
}
