import {Category} from './Category';

export class Liquor {
  private readonly _id: number;
  private readonly _name: string;
  private readonly _category: Category;

  constructor(id: number, name: string, category: Category) {
    this._id = id;
    this._name = name;
    this._category = category;
  }

  get id(): number {
    return this._id;
  }

  get name(): string {
    return this._name;
  }

  get category(): Category {
    return this._category;
  }
}
